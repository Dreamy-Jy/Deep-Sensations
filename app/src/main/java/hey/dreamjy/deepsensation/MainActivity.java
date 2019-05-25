package hey.dreamjy.deepsensation;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private static final String TAG = "MainActivity";

    private SensorManager mSensorManager;
    private Sensor mGryoscope;

    private TextView mSensorDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mGryoscope = mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        mSensorDisplay = (TextView) findViewById(R.id.text_sensor_display);

        mSensorManager.registerListener(MainActivity.this, mGryoscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public final void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override
    public  final void onSensorChanged(SensorEvent event) {
        mSensorDisplay.setText(String.valueOf(event.values[0]));
    }
}
