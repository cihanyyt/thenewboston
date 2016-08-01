package birbit.thenewboston;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;

/**
 * Created by Z003EUNW on 7/22/2016.
 */
public class GFX extends Activity{

    MyBringBack ourView;
    PowerManager.WakeLock wakeLock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //wake-lock
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
         wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");

        super.onCreate(savedInstanceState);

        wakeLock.acquire();

        ourView = new MyBringBack(this);
        setContentView(ourView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        wakeLock.release();
    }
}
