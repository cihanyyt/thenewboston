package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class SimpleBrowser extends Activity implements View.OnClickListener {

    EditText url;
    WebView ourBrowser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.simplebrowser);

        ourBrowser = (WebView) findViewById(R.id.wvBrowser);
        ourBrowser.setWebViewClient(new ourViewClient());
        ourBrowser.loadUrl("http://cihanyesilyurt.com");

        Button go = (Button) findViewById(R.id.bGo);
        Button refresh = (Button) findViewById(R.id.bRefresh);
        Button back = (Button) findViewById(R.id.bBack);
        Button forward = (Button) findViewById(R.id.bForward);
        Button clearHistory = (Button) findViewById(R.id.bHistory);
        url = (EditText) findViewById(R.id.etURL);

        go.setOnClickListener(this);
        refresh.setOnClickListener(this);
        back.setOnClickListener(this);
        forward.setOnClickListener(this);
        clearHistory.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bGo:
                String theWebsite = url.getText().toString();
                ourBrowser.loadUrl(theWebsite);
                break;
            case R.id.bRefresh:
                ourBrowser.reload();
                break;
            case R.id.bBack:
                if(ourBrowser.canGoBack())
                    ourBrowser.goBack();
                break;
            case R.id.bForward:
                if(ourBrowser.canGoForward())
                    ourBrowser.goForward();
                break;
            case R.id.bHistory:
                ourBrowser.clearHistory();
                break;
        }
    }
}
