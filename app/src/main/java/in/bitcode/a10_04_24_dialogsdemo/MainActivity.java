package in.bitcode.a10_04_24_dialogsdemo;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

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

        btnAlertDialog.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Submit");
                builder.setIcon(R.drawable.ic_launcher_background);
                builder.setMessage("Do you really want to submit?");

                //way 1 - attach listeners to buttons on dialog
//                builder.setPositiveButton("Yes",new PositiveButtonClickListener());
//                builder.setNegativeButton("No",new NegativeButtonClickListener());
//                builder.setNeutralButton("Not Confirm", new NeutralButtonClickListener());

                //way 2
                DialogInterface.OnClickListener listener = new AlertDialogButtonsClickListener();
                builder.setPositiveButton("yes",listener);
                builder.setNegativeButton("no",listener);
                builder.setNeutralButton("not confirmed",listener);

                builder.setOnCancelListener(new CancelClickListener());
                builder.setOnDismissListener(new DismissClickListener());

                AlertDialog alertDialog1 = builder.create();
                alertDialog1.setCancelable(false);
                alertDialog1.show();
            }
        });

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

    class CancelClickListener implements DialogInterface.OnCancelListener{
        @Override
        public void onCancel(DialogInterface dialogInterface) {
            Toast.makeText(MainActivity.this,"Cancel CLicked",Toast.LENGTH_LONG).show();
        }
    }

    class DismissClickListener implements DialogInterface.OnDismissListener{
        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            Toast.makeText(MainActivity.this,"Dismiss Clicked", Toast.LENGTH_LONG).show();
        }
    }

    class AlertDialogButtonsClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int which) {
            if (which == DialogInterface.BUTTON_POSITIVE){
                Toast.makeText(MainActivity.this,"Positive Button Clicked",Toast.LENGTH_LONG).show();
            } else if (which == DialogInterface.BUTTON_NEGATIVE){
                Toast.makeText(MainActivity.this,"Negative Button Clicked", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this,"Neutral Button Cliked",Toast.LENGTH_LONG).show();
            }
        }
    }

    class NeutralButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Neutral Button Clicked" + i,Toast.LENGTH_LONG).show();
        }
    }

    class NegativeButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Negative Button" + i, Toast.LENGTH_LONG).show();;
        }
    }

    class PositiveButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Toast.makeText(MainActivity.this,"Positive Button" + i,Toast.LENGTH_LONG).show();
        }
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