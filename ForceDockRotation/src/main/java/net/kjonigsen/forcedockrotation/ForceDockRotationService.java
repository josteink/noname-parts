package net.kjonigsen.forcedockrotation;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.view.WindowManager;
import android.widget.LinearLayout;

import java.beans.IndexedPropertyChangeEvent;

/**
 * Created by jostein on 29/06/13.
 */
public class ForceDockRotationService extends Service {
    LinearLayout orientationChanger;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        orientationChanger = new LinearLayout(this);

        // voodoo
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(0x7d6, 0x0, 0x1);

        params.screenOrientation = 0x4;

        WindowManager window = (WindowManager)getSystemService("window");
        window.addView(orientationChanger,params);

        orientationChanger.setVisibility(0);
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
