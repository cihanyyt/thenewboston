package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class SimpleBrowser extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        WebView ourBrowser = (WebView) findViewById(R.id.wvBrowser);
        ourBrowser.loadUrl("http://cihanyesilyurt.com");
    }
}
