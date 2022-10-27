package id.ac.umn.uts_00000044308_leocandraseldi;

import android.view.View;
import android.widget.Button;

public class VideoModel {
    private int image_thumbnail;
    private Button btnDelete;
    private String judul_video;
    private int link_video;
    private String desc_video;

    public VideoModel(int image_delete, int image_thumbnail, String judul_video, int link_video, String desc_video){
        this.image_thumbnail = image_thumbnail;
        this.btnDelete = btnDelete;
        this.judul_video = judul_video;
        this.link_video = link_video;
        this.desc_video = desc_video;
    }

    public String getJudul_video(){

        return judul_video;
    }
    public void setJudul_video(){

        this.judul_video = judul_video;
    }
    public int getImage_thumbnail(){

        return image_thumbnail;
    }
    public void setImage_thumbnail(){

        this.image_thumbnail = image_thumbnail;
    }
    public View.OnClickListener getBtnDelete(){

        return (View.OnClickListener) btnDelete;
    }
    public void setImage_delete(){

        this.btnDelete = btnDelete;
    }
    public int getLink(){
        return link_video;

    }
    public String getDesc_video(){
        return desc_video;
    }


}
