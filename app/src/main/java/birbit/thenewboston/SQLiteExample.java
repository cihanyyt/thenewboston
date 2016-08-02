package birbit.thenewboston;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Z003EUNW on 8/2/2016.
 */
public class SQLiteExample extends Activity implements View.OnClickListener {

    Button sqlUpdate, sqlView;
    EditText sqlName, sqlHotness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqliteexample);
        sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
        sqlView = (Button) findViewById(R.id.bSQLopenView);
        sqlName = (EditText) findViewById(R.id.etSQLName);
        sqlHotness = (EditText) findViewById(R.id.etSQLHotness);
        sqlView.setOnClickListener(this);
        sqlUpdate.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bSQLopenView:
                String name = sqlName.getText().toString();
                String hotness = sqlHotness.getText().toString();

                HotOrNot entry = new HotOrNot(SQLiteExample.this);
                entry.open();
                entry.createEntry(name, hotness);
                entry.close();

                break;
            case R.id.bSQLUpdate:
                break;
        }
    }
}
