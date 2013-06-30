package net.kjonigsen.forcedockrotation;

import android.content.Context;
import android.content.Intent;

/**
 * Created by jostein on 29/06/13.
 */
public class DeviceStatus {

    public final boolean IsDocked;

    public DeviceStatus(boolean isDocked)
    {
        IsDocked = isDocked;
    }

    public static DeviceStatus fromSystem(android.content.Context context)
    {
        return new DeviceStatus(true);
//        Object service = context.getSystemService("cm_dock");
//        if (service == null)
//        {
//            return new DeviceStatus(false);
//        }
//
//        // TODO: actually detect stuff
//        DeviceStatus result = new DeviceStatus(true);
//        return result;
    }

    public static DeviceStatus fromIntent(Intent intent, Context context) {
        return new DeviceStatus(true);
    }
}
