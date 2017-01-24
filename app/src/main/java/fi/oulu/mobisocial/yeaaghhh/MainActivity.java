package fi.oulu.mobisocial.yeaaghhh;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener{
    TextView sensorReading;
    Sensor sensor;
    Boolean hasMagnetometer=false;
    private SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sensorReading = (TextView) findViewById(R.id.sensorReading);

    }

    @Override
    protected void onResume() {
        super.onResume();

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        if(sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD)!=null){
            sensor= sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            Toast.makeText(getApplicationContext(),
                    "Magnetometer sensor detected",
                    Toast.LENGTH_LONG).show();
            hasMagnetometer=true    ;
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST);

        }else if (sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)!=null){
            sensor= sensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);
            Toast.makeText(getApplicationContext(),
                    "Accelerometer sensor detected",
                    Toast.LENGTH_LONG).show();
            sensorManager.registerListener(this,sensor,SensorManager.SENSOR_DELAY_FASTEST);
        }
        else {
            Toast.makeText(getApplicationContext(),
                    "No Magnetometer or Accelerometer sensors",
                    Toast.LENGTH_LONG).show();
            sensorReading.setText("No Magnetometer or Accelerometer sensors");
        }
    }
    @Override
    public void onPause() {
        super.onPause();

        sensorManager.unregisterListener(this);
    }
    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        sensorReading.setText(sensorEvent.values.toString());
        if(sensorEvent.sensor.getType()==Sensor.TYPE_ACCELEROMETER){

            sensorReading.setText(sensorEvent.values.toString());

        }
        if(sensorEvent.sensor.getType()==Sensor.TYPE_MAGNETIC_FIELD){

            sensorReading.setText(sensorEvent.values.toString());

        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
