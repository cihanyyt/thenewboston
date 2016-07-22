package birbit.thenewboston;

import android.content.Context;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Z003EUNW on 7/22/2016.
 */
public class MyBringBackSurface extends SurfaceView implements Runnable {

    SurfaceHolder ourHolder;
    Thread ourThread = null;
    boolean isRunning = true;

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
