package mx.edu.ittepic.proyectojuegonave_u3;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp,mpjefe,mpganaste;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new LienzoNaves(this));
    }

    public void musicaInicio(){
        mp = MediaPlayer.create(this, R.raw.musicafondo2);
        mp.start();
    }

    public void musicaPerdiste(){
        mp = MediaPlayer.create(this,R.raw.gameover);
        mp.start();
    }

    public void musicaGanaste(){
        mp = MediaPlayer.create(this,R.raw.win1);
        mp.start();
    }

    public void musicaJefe(){
        mp = MediaPlayer.create(this,R.raw.jefe);
        mp.start();
    }

    public void pararMusicaInicio(){
        mp.stop();
    }


}
