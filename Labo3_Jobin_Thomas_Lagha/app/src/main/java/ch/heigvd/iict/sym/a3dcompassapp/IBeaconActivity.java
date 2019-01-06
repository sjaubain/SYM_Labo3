package ch.heigvd.iict.sym.a3dcompassapp;
/*
import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
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
import java.util.Iterator;


public class IBeaconActivity  extends Activity implements BeaconConsumer {

    private ArrayList<String> beaconArrList;
    private ListView listView;
    private ArrayAdapter<String> arrayAdapter;
    private BeaconManager beaconManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode);
        beaconArrList = new ArrayList<String>();
        listView = (ListView) findViewById(R.id.listView);

        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.beaconArrList);
        listView.setAdapter(arrayAdapter);

        beaconManager = BeaconManager.getInstanceForApplication(this);
        beaconManager.getBeaconParsers().add(new BeaconParser(). setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        beaconManager.bind(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.beaconManager.unbind(this);
    }

    @Override
    public void onBeaconServiceConnect() {
        this.beaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    beaconArrList.clear();
                    for(Beacon beacon: beacons) {
                        beaconArrList.add("UUID: "+ beacon.getId1()
                                +"\nMAJOR: "+ beacon.getId2()
                                +"\nMINOR: "+ beacon.getId3()
                                +"\nRSSI: "+ beacon.getRssi()
                                +"\nTX: "+  beacon.getTxPower()
                                +"\nDISTANCE: "+ beacon.getDistance());
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            arrayAdapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        try {
            this.beaconManager.startRangingBeaconsInRegion(new Region("MyID", null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
*/
