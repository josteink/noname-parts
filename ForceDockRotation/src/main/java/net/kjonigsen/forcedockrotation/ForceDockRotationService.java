package net.kjonigsen.forcedockrotation;

import android.app.Service;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.PixelFormat;
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

    /**
    * Window type: system overlay windows, which need to be displayed
    * On top of everything else. These windows must not take input
    * Focus, or they will interfere with the keyguard.
    */
    public static final int TYPE_SYSTEM_OVERLAY = WindowManager.LayoutParams.FIRST_SYSTEM_WINDOW + 6;

    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        orientationChanger = new LinearLayout(this);

        WindowManager.LayoutParams params = new WindowManager.LayoutParams(TYPE_SYSTEM_OVERLAY, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.RGBA_8888);

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
