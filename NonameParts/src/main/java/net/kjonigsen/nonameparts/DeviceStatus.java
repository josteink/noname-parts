package net.kjonigsen.nonameparts;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/**
 * Created by jostein on 29/06/13.
 */
public class DeviceStatus {

    public final boolean IsDocked;

    public DeviceStatus(boolean isDocked)
    {
        IsDocked = isDocked;
    }

    /*
     * static API
     */

    public static DeviceStatus fromSystem(android.content.Context context)
    {
        IntentFilter ifilter = new IntentFilter(Intent.ACTION_DOCK_EVENT);
        Intent dockStatus = context.registerReceiver(null, ifilter);

        int dockState = dockStatus.getIntExtra(Intent.EXTRA_DOCK_STATE, -1);
        boolean isDocked = dockState != Intent.EXTRA_DOCK_STATE_UNDOCKED;

        return new DeviceStatus(isDocked);
    }

    public static DeviceStatus fromIntent(Intent intent, Context context) {
        return fromSystem(context);
    }
}
