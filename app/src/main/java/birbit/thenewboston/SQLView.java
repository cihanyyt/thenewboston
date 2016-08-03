package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class SQLView extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlview);
        TextView tv = (TextView) findViewById(R.id.tvSQLinfo);

        HotOrNot info = new HotOrNot(this);
        info.open();
        String data = info.getData();
        info.close();
        tv.setText(data);
    }
}
