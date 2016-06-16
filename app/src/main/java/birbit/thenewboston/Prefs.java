package birbit.thenewboston;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by Z003EUNW on 6/16/2016.
 */
public class Prefs extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.prefs);
    }
}
