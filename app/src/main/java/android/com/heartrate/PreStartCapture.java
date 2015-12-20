package android.com.heartrate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PreStartCapture extends AppCompatActivity implements View.OnClickListener  {

    private static final String TAG="PreStartCapture";
    private static int RESULT_HEART_RATE=1;
    private Button btnCaptureHeartRate;
    private EditText editTextHeartRate;

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        Log.d(TAG, "Got the result");

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == RESULT_HEART_RATE) {
                int heartRate = intent.getIntExtra("heart_rate", -1);

                if (heartRate != -1) {
                    editTextHeartRate.setText(Integer.toString(heartRate));
                }
            }
        }
    }

    @Override
    public void
    onClick (View view)
    {
        if (view.getId() == R.id.btnCaptureHeartRate) {
            Intent intent = new Intent(this, CaptureHeartRate.class);
            startActivityForResult(intent, RESULT_HEART_RATE);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pre_start_capture);

        btnCaptureHeartRate = (Button) findViewById (R.id.btnCaptureHeartRate);
        editTextHeartRate = (EditText) findViewById (R.id.editTextHeartRate);
        btnCaptureHeartRate.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_pre_start_capture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
