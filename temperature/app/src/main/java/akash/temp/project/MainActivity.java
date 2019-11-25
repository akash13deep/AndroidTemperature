package akash.temp.project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText ed1,ed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed = findViewById(R.id.editText);
        ed1 = findViewById(R.id.editText2);
    }

    public void convert(View v){

        RadioButton rd = findViewById(R.id.radioButton);
        RadioButton rd1 = findViewById(R.id.radioButton1);

        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        try {
            if (rd.isChecked()) {
                // 50°F - 32) x .5556
                String str = ed.getText().toString();
                double feh = Double.parseDouble(str);
                feh = ((feh - 32) * 0.5556);

                ed1.setText(""+df.format(feh));
            } else if (rd1.isChecked()) {
                // (30°C x 1.8) + 32 = 86°F
                double cel = Double.valueOf(ed1.getText().toString());

                ed.setText("" + df.format((cel * 1.8) + 32));
            }
        }catch(Exception e){

            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Error")
                    .setMessage(e.toString())
                    .setPositiveButton(android.R.string.ok, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }

    }

    public void clear(View v){
        ed.setText("");
        ed1.setText("");
    }


}
