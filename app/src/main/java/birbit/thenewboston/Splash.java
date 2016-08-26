package birbit.thenewboston;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Z003EUNW on 6/14/2016.
 */
public class Splash extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        Thread timer = new Thread(){
          public void run(){
              try{
                  sleep(500);
              }catch (InterruptedException e){
                  e.printStackTrace();
              }finally {
                  Intent openStartingPoint = new Intent("birbit.thenewboston.MENU");
                  startActivity(openStartingPoint);
              }
          }
        };
        timer.start();
    }

    protected void onPause(){
        super.onPause();
        finish();
    }
}
