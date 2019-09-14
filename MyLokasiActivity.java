package ans.ans;

import android.support.v7.app.AlertDialog;
import android.content.Context;

import android.location.Criteria;

import android.location.Location;

import android.location.LocationListener;

import android.location.LocationManager;

import android.os.Bundle;

import android.app.Activity;

import android.view.Menu;

import android.widget.TextView;

import android.widget.Toast;
public class MyLokasiActivity extends Activity implements LocationListener {

    LocationManager locationmanager;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_lokasi);

        locationmanager=(LocationManager)getSystemService(Context.LOCATION_SERVICE);

        Criteria cri=new Criteria();

        String provider=locationmanager.getBestProvider(cri,false);

        if(provider!=null & !provider.equals(""))

        {

            Location location=locationmanager.getLastKnownLocation(provider);

            locationmanager.requestLocationUpdates(provider,0,0,this);

            if(location!=null)

            {

                onLocationChanged(location);

            }

            else{

                Toast.makeText(getApplicationContext(),"location not found",Toast.LENGTH_LONG ).show();

            }

        }

        else

        {

            Toast.makeText(getApplicationContext(),"Provider is null",Toast.LENGTH_LONG).show();

        }

    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

// Inflate the menu; this adds items to the action bar if it is present.

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override

    public void onLocationChanged(Location location) {

        TextView textView2=(TextView)findViewById(R.id.textview2);

        TextView textView3=(TextView)findViewById(R.id.textview1);

        textView2.setText("Latitude : "+location.getLatitude());

        textView3.setText("Longitude : "+ location.getLongitude());
        // AlertDialog.Builder builder= new AlertDialog.Builder( MyLokasiActivity.this);
        // builder.setTitle("MASUK SISTEM");
        // builder.setMessage("Longitude"+location.getLatitude());
        // AlertDialog dgAlert=builder.create();
        // dgAlert.show();

    }

    @Override

    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override

    public void onProviderEnabled(String s) {

    }

    @Override

    public void onProviderDisabled(String s) {

    }

}