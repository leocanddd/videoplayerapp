package id.ac.umn.uts_00000044308_leocandraseldi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import org.w3c.dom.Text;

public class Video1 extends AppCompatActivity {
    VideoView videoView;
    TextView tvDesc;
    TextView tvDesc2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video1);
        tvDesc = findViewById(R.id.judulVideo);
        tvDesc2 = findViewById(R.id.teksDesc);
        String nama = getIntent().getStringExtra("tes");
        int linkVideo = getIntent().getIntExtra("tes2", 0);
        String deskripsiVideo = getIntent().getStringExtra("tes3");
        tvDesc.setText(nama);
        tvDesc2.setText(deskripsiVideo);

        getSupportActionBar().setTitle(nama);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        videoView = findViewById(R.id.yoengkim);
        String videoPath = "android.resource://" + getPackageName()+"/" + linkVideo;
        Uri uri = Uri.parse(videoPath);

        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.navbutton:
                break;
            case R.id.keHome:
                bukaHome2();
                break;
            case R.id.keProfile:
                bukaProfile2();
                break;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void bukaHome2() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void bukaProfile2(){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }
}