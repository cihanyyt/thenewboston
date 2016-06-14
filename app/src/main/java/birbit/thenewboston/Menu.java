package birbit.thenewboston;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

/**
 * Created by Z003EUNW on 6/14/2016.
 */
public class Menu extends ListActivity{

    String classes[] = {"startingPoint","example1","example2",
            "example3","example4","example5",,"example6"};

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

    }
}
