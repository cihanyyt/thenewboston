package birbit.thenewboston;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Z003EUNW on 8/1/2016.
 */
public class SoundStuff extends Activity implements View.OnClickListener, View.OnLongClickListener {

    SoundPool soundPool;
    int exp = 0;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View v = new View(this);
        v.setOnClickListener(this);
        v.setOnLongClickListener(this);
        setContentView(v);
        soundPool = new SoundPool(5, AudioManager.STREAM_MUSIC, 0);
        exp = soundPool.load(this, R.raw.wasp, 1);
        mediaPlayer = MediaPlayer.create(this,R.raw.music);
    }

    @Override
    public void onClick(View v) {
        if(exp != 0)
            soundPool.play(exp, 1, 1, 0, 0,1);
    }


    @Override
    public boolean onLongClick(View v) {
        mediaPlayer.start();
        return false;
    }
}
