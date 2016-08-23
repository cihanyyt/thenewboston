package birbit.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by cihany on 23/08/2016.
 */
public class Accelerate extends Activity implements SensorEventListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyBringBackSurface(this));
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    public class MyBringBackSurface extends SurfaceView implements Runnable {

        SurfaceHolder ourHolder;
        Thread ourThread = null;
        boolean isRunning = false;

        public MyBringBackSurface(Context context) {
            super(context);
            ourHolder = getHolder();
        }

        public void pause(){
            isRunning = false;
            while(true){
                try {
                    ourThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            ourThread = null;
        }

        public void resume(){
            isRunning = true;
            ourThread = new Thread(this);
            ourThread.start();
        }

        @Override
        public void run() {

            while (isRunning){
                if(!ourHolder.getSurface().isValid()) {
                    continue;
                }

                Canvas canvas = ourHolder.lockCanvas();
                canvas.drawRGB(02,02,150);


                ourHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

}
