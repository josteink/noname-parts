package net.kjonigsen.forcedockrotation;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;

import java.lang.annotation.Annotation;

/**
 * Created by jostein on 29/06/13.
 */

public class MainActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        this.setContentView(R.layout.MainActivity);

        CheckInitialDockState task = new CheckInitialDockState();
        task.execute(R.layout.MainActivity, savedInstanceState, null);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mainactivitymenu, menu);
        return true;
    }
}