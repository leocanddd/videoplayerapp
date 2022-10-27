package id.ac.umn.uts_00000044308_leocandraseldi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class VideoList extends RecyclerView.Adapter<VideoList.ViewHolder>{

    private final Context context;
    private final ArrayList<VideoModel> videoModelArrayList;
    private final DialogApus dialogApus;

    public VideoList(Context context, ArrayList<VideoModel> videoModelArrayList, DialogApus dialogApus){
        this.context = context;
        this.videoModelArrayList = videoModelArrayList;
        this.dialogApus = dialogApus;
    }

    @NonNull
    @Override
    public VideoList.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_card, parent, false);
        return new VideoList.ViewHolder(view, dialogApus);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoModel model = videoModelArrayList.get(position);
        holder.image_thumbnail.setImageResource(model.getImage_thumbnail());
        holder.judul_video.setText(model.getJudul_video());
    }

    @Override
    public int getItemCount() {
        return videoModelArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView image_thumbnail;
        private final ImageView btn_delete;
        private final TextView judul_video;
        private VideoList adapter;
        TextView textView;

        public ViewHolder(@NonNull View itemView, DialogApus dialogApus) {
            super(itemView);
            image_thumbnail = itemView.findViewById(R.id.descVideo1);
            btn_delete = itemView.findViewById(R.id.hapus);
            judul_video = itemView.findViewById(R.id.judul);
            textView = itemView.findViewById(R.id.judul);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view){
                    if(dialogApus!=null){
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            dialogApus.onClick(position);
                        }
                    }

                }
            });
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(dialogApus!=null){
                        int position = getAbsoluteAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            dialogApus.onDelete(position);
                        }
                    }
                }
            });
        }
    }
}