package birbit.thenewboston;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SlidingDrawer;

/**
 * Created by Z003EUNW on 8/1/2016.
 */
public class Slider extends Activity implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, SlidingDrawer.OnDrawerOpenListener {

    SlidingDrawer slidingDrawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sliding);

        Button handle1 = (Button) findViewById(R.id.handle1);
        Button handle2 = (Button) findViewById(R.id.handle2);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cbSlidable);
        checkBox.setOnCheckedChangeListener(this);

        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        slidingDrawer.setOnDrawerOpenListener(this);
        handle1.setOnClickListener(this);
        handle2.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.isChecked()){
            slidingDrawer.lock();
        }else {
            slidingDrawer.unlock();
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.handle1:
                slidingDrawer.open();
                break;
            case R.id.handle2:
                slidingDrawer.close();
                break;

        }
    }

    @Override
    public void onDrawerOpened() {
        MediaPlayer mp = MediaPlayer.create(this, R.raw.wasp);
        mp.start();
    }
}
