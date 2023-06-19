package ru.serujimir.visualnovel;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class AuthorActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);
        mediaPlayer = MediaPlayer.create(this, R.raw.tymenceva);
    }
    public void Back (View v) {
        Intent Main = new Intent(AuthorActivity.this, MainActivity.class);
        startActivity(Main);
    }
    public void Tymenceva (View v) {
        mediaPlayer.start();
    }
}
