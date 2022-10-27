package id.ac.umn.uts_00000044308_leocandraseldi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        /*tombol back yang jika ditekan akan membawa
        user kembali ke halaman sebelumnya*/
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        LinearLayout linearLayout = findViewById(R.id.layoutprofile);
        AnimationDrawable bg = (AnimationDrawable) linearLayout.getBackground();
        bg.setEnterFadeDuration(500);
        bg.setExitFadeDuration(500);
        bg.start();
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}