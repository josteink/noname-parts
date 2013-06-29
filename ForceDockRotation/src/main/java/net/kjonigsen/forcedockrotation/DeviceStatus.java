package net.kjonigsen.forcedockrotation;

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
        Object service = context.getSystemService("cm_dock");
        if (service == null)
        {
            return new DeviceStatus(false);
        }

        // TODO: actually detect stuff
        DeviceStatus result = new DeviceStatus(true);
        return result;
    }
}
