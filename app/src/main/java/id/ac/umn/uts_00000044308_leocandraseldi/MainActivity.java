package id.ac.umn.uts_00000044308_leocandraseldi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private Button button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = this.findViewById(R.id.button1);
        setContentView(R.layout.activity_main);
        initView();

        LinearLayout linearLayout = findViewById(R.id.layoututama);
        AnimationDrawable bg = (AnimationDrawable) linearLayout.getBackground();
        bg.setEnterFadeDuration(500);
        bg.setExitFadeDuration(500);
        bg.start();
    }

    /*initialize view*/
    private void initView(){
        button2 = (Button) findViewById(R.id.button2);
        button2.setOnClickListener(this::button2onClick);
    }
    /*menampilkan sebuah modal box login*/
    private void button2onClick(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setCancelable(false);
        builder.setTitle(R.string.login);
        final View dialogView = LayoutInflater.from(view.getContext()).inflate(R.layout.layout_dialog, null);
        builder.setView(dialogView);
        final AlertDialog alertDialog = builder.show();
        /*input box yang menerima input nama user*/
        final EditText editTextUsername = dialogView.findViewById(R.id.editTextUsername);
        Button buttonLogin = dialogView.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(view1 -> {
            String username = editTextUsername.getText().toString();
            if(username.isEmpty()){
                /*input login tidak boleh kosong, Jika kosong maka akan muncul pesan bahwa nama user harus diisi*/
                Toast.makeText(getApplicationContext(), R.string.invalid, Toast.LENGTH_SHORT).show();
            }else{
                Intent intent = new Intent(MainActivity.this, Library.class);
                /*mengirim input user untuk ditampilkan sebagai nama user di library*/
                String message = "Hello" + "," + editTextUsername.getText().toString();
                intent.putExtra("key", message);
                startActivity(intent);
            }
            alertDialog.dismiss();
        });
        Button buttonCancel = dialogView.findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(v -> alertDialog.dismiss());
    }

    //Method untuk pindah ke activity Profile
    public void goProfile (View view){
        Intent intent = new Intent(this, Profile.class);
        startActivity(intent);
    }

}
