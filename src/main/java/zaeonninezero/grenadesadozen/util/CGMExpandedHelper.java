package zaeonninezero.grenadesadozen.util;

import com.mrcrayfish.guns.GunMod;

public class CGMExpandedHelper
{
	private static boolean detectFail = false;
	
    public static boolean isExpandedInstalled()
    {
    	if (detectFail)
    		return false;
    	
    	try
    	{
    		GunMod.hasCGMExpanded();
    	}
    	catch (NoClassDefFoundError ignored)
    	{
    		detectFail = true;
    	}
    	
    	return false;
    }
}