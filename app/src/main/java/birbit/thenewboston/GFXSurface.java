package birbit.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by Z003EUNW on 7/22/2016.
 */
public class GFXSurface extends Activity implements View.OnTouchListener {

    MyBringBackSurface ourSurfaceView;
    float x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourSurfaceView = new MyBringBackSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x = 0;
        y = 0;

        setContentView(ourSurfaceView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        ourSurfaceView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        ourSurfaceView.resume();
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        x = event.getX();
        y = event.getY();

        return true;
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
                if(x != 0 && y != 0){
                    Bitmap test = BitmapFactory.decodeResource(getResources(),R.drawable.monster);
                    canvas.drawBitmap(test, x-test.getWidth()/2, y-test.getHeight()/2, null);
                }
                ourHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

}
