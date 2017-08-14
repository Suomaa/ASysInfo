package rpb.suomaasoft.asysinfo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.content.Context;

//Our class extending fragment
public class BatteryTabActivity extends Fragment {

    public Double getBatteryCapacity(){

        Object powerProfile = null;
        Double batteryCapacity = 0.0;
        final String POWER_PROFILE_CLASS = "com.android.internal.os.PowerProfile";

        try{
            powerProfile = Class.forName(POWER_PROFILE_CLASS)
                    .getConstructor(Context.class).newInstance(this);
        }catch (Exception e){
            e.printStackTrace();
        }

        try{
            batteryCapacity = (Double) Class.forName(POWER_PROFILE_CLASS)
                    .getMethod("getAveragePower", java.lang.String.class)
                    .invoke(powerProfile, "battery.capacity");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return batteryCapacity;
    }

    //Override method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.activity_battery_tab, container, false);

        final TextView textViewBatteryInfo = (TextView) rootView.findViewById(R.id.battery_info_display);

        textViewBatteryInfo.setText("Battery Capacity: " + getBatteryCapacity() + "\n");
        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return rootView;
    }
}