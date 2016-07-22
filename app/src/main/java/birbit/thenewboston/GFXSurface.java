package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Z003EUNW on 7/22/2016.
 */
public class GFXSurface extends Activity {

    MyBringBackSurface ourSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ourSurfaceView = new MyBringBackSurface(this);
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
}
