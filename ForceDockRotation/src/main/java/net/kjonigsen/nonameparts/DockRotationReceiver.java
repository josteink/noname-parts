package net.kjonigsen.nonameparts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by jostein on 29/06/13.
 */
public class DockRotationReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        DeviceStatus status = DeviceStatus.fromIntent(intent, context);
        startStopService(context, status.IsDocked);
    }

    public static void startStopService(Context context, boolean isDocked) {
        boolean enabled = isDocked && getEnabled(context);
        Intent serviceIntent = new Intent(context, ForceDockRotationService.class);

        if (enabled)
        {
            context.startService(serviceIntent);
        }
        else
        {
            context.stopService(serviceIntent);
        }
    }

    private static Boolean getEnabled(Context context)
    {
        String pref = "pref_force_landscape";
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getBoolean(pref, true);
    }
}
