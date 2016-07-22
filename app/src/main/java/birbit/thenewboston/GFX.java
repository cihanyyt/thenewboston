package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Z003EUNW on 7/22/2016.
 */
public class GFX extends Activity{

    MyBringBack ourView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ourView = new MyBringBack(this);
        setContentView(ourView);
    }
}
