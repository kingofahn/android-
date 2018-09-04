package app.rstone.com.myschedular;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import org.w3c.dom.Text;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main extends AppCompatActivity {
    String date = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final Context ctx = Main.this;
        TextView today = findViewById(R.id.today);
        CalendarView calender = findViewById(R.id.calender);
        RadioButton rdoCalendar = findViewById(R.id.rdoCalendar);
        RadioButton rdoTime = findViewById(R.id.rdoTime);
        TimePicker time = findViewById(R.id.time);
        TextView year = findViewById(R.id.year);
        TextView month = findViewById(R.id.month);
        TextView day = findViewById(R.id.day);
        TextView hour = findViewById(R.id.hour);
        TextView minute = findViewById(R.id.minute);
        today.setText(new SimpleDateFormat ("yyyy/MM/dd hh:mm").format(new Date()));
        time.setVisibility(View.INVISIBLE);

        findViewById(R.id.rdoCalendar).setOnClickListener(
                (View v) ->{
                    calender.setVisibility(View.VISIBLE);
                    time.setVisibility(View.INVISIBLE);
                }
        );
        findViewById(R.id.rdoTime).setOnClickListener(
                (View v) ->{
                    calender.setVisibility(View.INVISIBLE);
                    time.setVisibility(View.VISIBLE);
                }
        );

        findViewById(R.id.btnEnd).setOnClickListener(
                (View v)-> {
                    year.setText(date.split("/")[0]);
                    month.setText(date.split("/")[1]);
                    day.setText(date.split("/")[2]);
                    hour.setText(String.valueOf(time.getHour()));
                    minute.setText(String.valueOf(time.getMinute()));
                }
        );

        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                date = year+"/"+month+"/"+dayOfMonth;
                Log.d("date : ",date+"");
                Log.d("hour : ",time.getHour()+"");
                Log.d("min : ",time.getMinute()+"");
                TextView y = findViewById(R.id.year);
                TextView m = findViewById(R.id.month);
                TextView d = findViewById(R.id.day);
                y.setText(year+"");
                m.setText(month+"");
                d.setText(dayOfMonth+"");
            }
        });

        time.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(@NonNull TimePicker view, int hourOfDay, int minute) {
                TextView h = findViewById(R.id.hour);
                TextView m = findViewById(R.id.minute);
                h.setText(hourOfDay+"");
                m.setText(minute+"");
                Log.d("hour : ", h.getText()+"");
                Log.d("minute : ", m.getText()+"");
            }
        });
    }
}