package id.ac.umn.uts_00000044308_leocandraseldi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Carousel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import android.widget.VideoView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Library extends AppCompatActivity implements DialogApus {
    private Toolbar toolbar;
    /*String[] data;*/
    ImageView imageView;
    ImageView btnHapus;
    DialogApus dialogApus2;
    ArrayList<VideoModel> videoModelArrayList = new ArrayList<VideoModel>();
    private VideoList videoList;
    BottomSheetDialog dialog;
    String deskripsi1, deskripsi2, deskripsi3, deskripsi4, deskripsi5, deskripsi6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);
        /*“Hello, [NAMA USER]” dimana[NAMA USER] berasal dari input user pada Halaman Login*/
        String message = getIntent().getStringExtra("key").toString();
        setTitle(message);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        /*toast “Welcome + [NAMA USER]”*/
        Toast.makeText(getApplicationContext(), getIntent().getStringExtra("key").toString(), Toast.LENGTH_SHORT).show();

        deskripsi1 = "Yoasobi - Tracing That Dream";
        deskripsi2 = "Spy x Family AMV";
        deskripsi3 = "Maroon 5 - Stereo Hearts AMV";
        deskripsi4 = "Levi Ackerman - Attack On Titan";
        deskripsi5 = "Anime Short Edit";
        deskripsi6 = "Zero Two - Darling In The Franxx";
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        videoModelArrayList.add(new VideoModel(R.id.hapus, R.drawable.videoicon, "Video 1",R.raw.yoasobi, deskripsi1));
        videoModelArrayList.add(new VideoModel(R.drawable.button, R.drawable.videoicon, "Video 2",R.raw.anya, deskripsi2));
        videoModelArrayList.add(new VideoModel(R.drawable.button, R.drawable.videoicon, "Video 3", R.raw.marin, deskripsi3));
        videoModelArrayList.add(new VideoModel(R.drawable.button, R.drawable.videoicon, "Video 4", R.raw.levi, deskripsi4));
        videoModelArrayList.add(new VideoModel(R.drawable.button, R.drawable.videoicon, "Video 5", R.raw.anime, deskripsi5));
        videoModelArrayList.add(new VideoModel(R.drawable.button, R.drawable.videoicon, "Video 6", R.raw.anime3, deskripsi6));
        videoList = new VideoList(this, videoModelArrayList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(videoList);

        btnHapus = findViewById(R.id.hapus);
        dialog = new BottomSheetDialog(this);

        LinearLayout linearLayout = findViewById(R.id.layoutlibrary);
        AnimationDrawable bg = (AnimationDrawable) linearLayout.getBackground();
        bg.setEnterFadeDuration(500);
        bg.setExitFadeDuration(500);
        bg.start();

    }
    /*method untuk keluar untuk kembali ke Tampilan Awal*/
    private void bukaHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

    /*method untuk ke tampilan profil*/
    private void bukaProfile() {
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

    /*menuampilkan option menu yang berisi tombol untuk ke tampilan profil dan juga tombol
    keluar ntuk kembali ke Tampilan Awal.*/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /*passing item menu yang dipilih*/
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navbutton:
                break;
            case R.id.keHome:
                bukaHome();
                break;
            case R.id.keProfile:
                bukaProfile();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDelete(int position) {
        createBottomDialog(position);
        dialog.show();
        dialog.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

    }

    @Override
    public void onClick(int position) {
        Intent intent = new Intent(Library.this, Video1.class);
        intent.putExtra("tes", videoModelArrayList.get(position).getJudul_video());
        intent.putExtra("tes2", videoModelArrayList.get(position).getLink());
        intent.putExtra("tes3", videoModelArrayList.get(position).getDesc_video());
        startActivity(intent);

    }
    private void createBottomDialog(int pos) {

        View view = getLayoutInflater().inflate(R.layout.layout_dialoglibrary, null, false);
        Button yes = view.findViewById(R.id.buttonYes);
        Button cancel = view.findViewById(R.id.buttonNo);
        yes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                videoModelArrayList.remove(pos);
                videoList.notifyItemRemoved(pos);
                dialog.dismiss();
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                dialog.dismiss();
            }
        });

        dialog.setContentView(view);

    }

}