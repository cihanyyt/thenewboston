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
    float x, y, sX, sY, fX, fY, dX, dY, aniX, aniY, scaX, scaY;
    Bitmap monsterSmiling, monsterO;
    boolean monsterShot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourSurfaceView = new MyBringBackSurface(this);
        ourSurfaceView.setOnTouchListener(this);
        x = y = sX = sY = fX = fY = 0;
        dX = dY = aniX = aniY = scaX = scaY = 0;
        monsterShot = false;

        monsterSmiling = BitmapFactory.decodeResource(getResources(),R.drawable.monster);
        monsterO = BitmapFactory.decodeResource(getResources(),R.drawable.monster_selected);

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

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        x = event.getX();
        y = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                sX = event.getX();
                sY = event.getY();
                dX = dY = aniX = aniY = scaX = scaY = fX = fY = 0;
                monsterShot = false;
                break;
            case MotionEvent.ACTION_UP:
                fX = event.getX();
                fY = event.getY();
                dX = fX - sX;
                dY = fY - sY;
                scaX = dX/30;
                scaY = dY/30;
                x = y = 0;
                break;
        }

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

                if((x != 0 && y != 0) ){
                    canvas.drawBitmap(monsterSmiling, x- monsterSmiling.getWidth()/2, y- monsterSmiling.getHeight()/2, null);
                }

                if((sX != 0 && sY != 0 ) && ((monsterSmiling.getWidth()/2)-aniX == 0 )){
                    canvas.drawBitmap(monsterO, sX- monsterO.getWidth()/2, sY- monsterO.getHeight()/2, null);
                }

                if((fX != 0 && fY != 0) ){
                    canvas.drawBitmap(monsterSmiling, fX-(monsterSmiling.getWidth()/2)-aniX, fY-(monsterSmiling.getHeight()/2)-aniY, null);
                    //canvas.drawBitmap(monsterO, fX-(monsterO.getWidth()/2), fY-(monsterO.getHeight()/2), null);
                }

                aniX += scaX;
                aniY += scaY;

                ourHolder.unlockCanvasAndPost(canvas);
            }

        }
    }

}
