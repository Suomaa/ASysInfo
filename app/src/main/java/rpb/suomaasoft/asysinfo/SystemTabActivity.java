package rpb.suomaasoft.asysinfo;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.text.Html;

//Our class extending fragment
public class SystemTabActivity extends Fragment {

    //Override method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View rootView = inflater.inflate(R.layout.activity_system_tab, container, false);

        final TextView textViewInfo = (TextView) rootView.findViewById(R.id.system_info_display);


        textViewInfo.setText(
                Html.fromHtml("<h2>Operation System</h2>" +
                        "</hr>" +
                "SERIAL: " + Build.SERIAL + "\n" +
                        "MODEL: " + Build.MODEL + "\n" +
                        "ID: " + Build.ID + "\n" +
                        "Manufacture: " + Build.MANUFACTURER + "\n" +
                        "Brand: " + Build.BRAND + "\n" +
                        "Type: " + Build.TYPE + "\n" +
                        "User: " + Build.USER + "\n" +
                        "BASE: " + Build.VERSION_CODES.BASE + "\n" +
                        "INCREMENTAL: " + Build.VERSION.INCREMENTAL + "\n" +
                        "SDK:  " + Build.VERSION.SDK + "\n" +
                        "BOARD: " + Build.BOARD + "\n" +
                        "BRAND: " + Build.BRAND + "\n" +
                        "HOST: " + Build.HOST + "\n" +
                        "FINGERPRINT: "+Build.FINGERPRINT + "\n" +
                        "Version Code: " + Build.VERSION.RELEASE)
        );


        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return rootView;
    }
}