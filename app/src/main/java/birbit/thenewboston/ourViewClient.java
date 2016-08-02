package birbit.thenewboston;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class ourViewClient extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }
}
