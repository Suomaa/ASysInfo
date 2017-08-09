package rpb.suomaasoft.asysinfo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

//Extending FragmentStatePagerAdapter
public class Pager extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                SystemTabActivity systemTabActivity = new SystemTabActivity();
                return systemTabActivity;
            case 1:
                BatteryTabActivity batteryTabActivity = new BatteryTabActivity();
                return batteryTabActivity;
            default:
                return null;
        }
    }

    //Override method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}