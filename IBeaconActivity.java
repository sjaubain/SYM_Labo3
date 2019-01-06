package ch.heigvd.iict.sym.a3dcompassapp.ibeacon;

import android.os.Bundle;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import ch.heigvd.iict.sym.a3dcompassapp.R;

/**
 * iBeacon activity
 * Source: https://altbeacon.github.io/android-beacon-library/samples.html
 *
 * @author Amel Dussier
 * @author Thibaud Besseau
 */
public class IBeaconActivity extends AppCompatActivity implements BeaconConsumer {

    private ListView beaconListView;
    private List<String> beaconsList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private BeaconManager beaconManager;

    // used for logging
    protected static final String TAG = "MonitoringActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beacon);

        // Recuperate UI things
        beaconListView = (ListView) findViewById(R.id.listView);

        // Adapter preparation for the list
        adapter = new ArrayAdapter<>(IBeaconActivity.this,
                android.R.layout.simple_list_item_1, beaconsList);
        beaconListView.setAdapter(adapter);

        // Beacon initialization
        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=beac,i:4-19,i:20-21,i:22-23,p:24-24,d:25-25"));

        beaconManager.bind(this);
        System.out.println("Hello0");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        System.out.println("In the function");

        beaconManager.addRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {

                //clear the list of beacons
                beaconsList.clear();

                System.out.println("Hello");

                //parse the beacon
                for(Beacon beacon : beacons)
                {
                    beaconsList.add("RSSI: " + beacon.getRssi()+ "\n"+
                        "Numéro majeur du beacon: "+ beacon.getId2() + "\n" +
                        "Numéro minieur du beacon: "+ beacon.getId3());

                    System.out.println("New beacon: "+ beacon.getRssi()+ "\n");
                }

                // update listView
                adapter.notifyDataSetChanged();
            }
        });

        try {
            beaconManager.startRangingBeaconsInRegion(
                new Region("myMonitoringUniqueId", null, null, null));
        } catch (RemoteException e) {
            Log.e(TAG,"Exe", e);
        }
    }
}
