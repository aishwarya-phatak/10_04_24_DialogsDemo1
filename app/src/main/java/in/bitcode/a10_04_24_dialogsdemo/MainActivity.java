package in.bitcode.a10_04_24_dialogsdemo;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button btnAlertDialog;
    Button btnDatePickerDialog;
    Button btnTimePickerDialog;
    Button btnLoginDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeViews();

//        btnAlertDialog.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

        btnDatePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog =
                        new DatePickerDialog(MainActivity.this,
                        new DatePickerDialogClickListener(),
                                2024,
                                03,     //jan -- represented by 0
                                19
                );
                datePickerDialog.show();
            }
        });

        btnTimePickerDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerDialog timePickerDialog =
                        new TimePickerDialog(MainActivity.this,
                                new TimePickerDialogClickListener(),
                                05,
                                35,
                                true
                        );
                timePickerDialog.show();
            }
        });
    }

    class TimePickerDialogClickListener implements TimePickerDialog.OnTimeSetListener{
        @Override
        public void onTimeSet(TimePicker timePicker, int hour, int minute) {
            btnTimePickerDialog.setText(hour + "--" + minute + "PM");
        }
    }

    class DatePickerDialogClickListener implements DatePickerDialog.OnDateSetListener{
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            btnDatePickerDialog.setText(year + "--" + month + "--" + day);
            // i --> year, i1 --> month, i2 --> day
        }
    }

    private void initializeViews(){
       btnAlertDialog = findViewById(R.id.btnAlertDialog);
       btnDatePickerDialog = findViewById(R.id.btnDatePickerDialog);
       btnTimePickerDialog = findViewById(R.id.btnTimePickerDialog);
       btnLoginDialog = findViewById(R.id.btnLoginDialog);
    }
}