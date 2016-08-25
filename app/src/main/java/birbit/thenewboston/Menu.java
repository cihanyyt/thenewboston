package birbit.thenewboston;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by Z003EUNW on 6/14/2016.
 * Menu activity
 */
public class Menu extends ListActivity{

    String classes[] = {"startingPoint","TextPlay","Email",
            "Camera","Data","GFX","GFXSurface", "SoundStuff",
            "Slider","Tabs","SimpleBrowser","Flipper", "SharedPrefs",
            "InternalData", "ExternalData", "SQLiteExample", "Accelerate", "HelloMapsActivity"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setListAdapter(new ArrayAdapter<>(Menu.this,
                android.R.layout.simple_list_item_1, classes));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String cheese = classes[position];
        super.onListItemClick(l, v, position, id);
        try {
            Class ourClass = Class.forName("birbit.thenewboston." + cheese);
            Intent ourIntent = new Intent(Menu.this, ourClass);
            startActivity(ourIntent);
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp = getMenuInflater();
        blowUp.inflate(R.menu.cool_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.aboutUs:
                startActivity(new Intent("birbit.thenewboston.ABOUT"));
                break;
            case R.id.preferences:
                startActivity(new Intent("birbit.thenewboston.PREFS"));
                break;
            case R.id.exit:
                finish();
                break;
        }
        return false;
    }
}
