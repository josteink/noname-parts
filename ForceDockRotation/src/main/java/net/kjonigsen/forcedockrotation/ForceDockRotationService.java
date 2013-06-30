package net.kjonigsen.forcedockrotation;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.beans.IndexedPropertyChangeEvent;

/**
 * Created by jostein on 29/06/13.
 */
public class ForceDockRotationService extends Service {
    LinearLayout orientationChanger;

    private final static int FORCED_SCREEN_ORIENTATION = 0x4;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        orientationChanger = new LinearLayout(this);

        // voodoo
        int layoutFlags = WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW
                | WindowManager.LayoutParams.FLAGS_CHANGED
                | WindowManager.LayoutParams.TYPE_APPLICATION;
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(layoutFlags, 0x0, 0x1);

        params.screenOrientation = FORCED_SCREEN_ORIENTATION;

//        WindowManager window = (WindowManager)getSystemService("window");
//        window.addView(orientationChanger,params);
//
//        orientationChanger.setVisibility(0);
    }

    @Override
    public void onDestroy() {
        if (orientationChanger == null)
        {
            return;
        }

        WindowManager window = (WindowManager)getSystemService("window");
        window.removeView(orientationChanger);
        orientationChanger = null;
    }
}
