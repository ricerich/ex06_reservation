package com.example.ex06_reservation;

import android.graphics.Color;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
{
//    Chronometer chrono;
//    Button btnStart, btnEnd;

    RadioButton rdoCal, rdoTime;
//    CalendarView calView;
    TimePicker tPicker;
    TextView tvYear, tvMonth, tvDay, tvHour, tvMinute;

//    int selectYear, selectMonth, selectDay;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("시간 예약");

        // 버튼
//        btnStart = (Button) findViewById(R.id.btnStart);
//        btnEnd = (Button) findViewById(R.id.btnEnd);

        // 크로노미터
        Chronometer chrono = (Chronometer) findViewById(R.id.chronometer1);

        // 라디오버튼 2개
        rdoCal = (RadioButton) findViewById(R.id.rdoCal);
        rdoTime = (RadioButton) findViewById(R.id.rdoTime);

        // FrameLayout의 2개 위젯
        tPicker = (TimePicker) findViewById(R.id.timePicker1);
//        calView = (CalendarView) findViewById(R.id.calendarView1);
        DatePicker dPicker1 = findViewById(R.id.datePicker1);

        // 텍스트뷰 중에서 연,월,일,시,분 숫자
        tvYear = (TextView) findViewById(R.id.tvYear);
        tvMonth = (TextView) findViewById(R.id.tvMonth);
        tvDay = (TextView) findViewById(R.id.tvDay);
        tvHour = (TextView) findViewById(R.id.tvHour);
        tvMinute = (TextView) findViewById(R.id.tvMinute);

        // 처음에는 2개를 안보이게 설정
        tPicker.setVisibility(View.INVISIBLE);
//        calView.setVisibility(View.INVISIBLE);
        dPicker1.setVisibility(View.INVISIBLE);

        rdoCal.setVisibility(View.INVISIBLE);
        rdoTime.setVisibility(View.INVISIBLE);

        rdoCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.INVISIBLE);
//                calView.setVisibility(View.VISIBLE);
                dPicker1.setVisibility(View.VISIBLE);
            }
        });

        rdoTime.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                tPicker.setVisibility(View.VISIBLE);
//                calView.setVisibility(View.INVISIBLE);
                dPicker1.setVisibility(View.INVISIBLE);
            }
        });

        // 타이머 설정
//        btnStart.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                chrono.setBase(SystemClock.elapsedRealtime());
//                chrono.start();
//                chrono.setTextColor(Color.RED);
//            }
//        });

        chrono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chrono.setBase(SystemClock.elapsedRealtime());
                chrono.start();
                chrono.setTextColor(Color.RED);

                rdoCal.setVisibility(View.VISIBLE);
                rdoTime.setVisibility(View.VISIBLE);
            }
        });

        // 버튼을 클릭하면 날짜,시간을 가져온다.
//        btnEnd.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                chrono.stop();
//                chrono.setTextColor(Color.BLUE);
//
////                tvYear.setText(Integer.toString(selectYear));//년
////                tvMonth.setText(Integer.toString(selectMonth));// 월
////                tvDay.setText(Integer.toString(selectDay));// 일
//
//                tvYear.setText(Integer.toString(dPicker1.getYear()));//년
//                tvMonth.setText(Integer.toString(dPicker1.getMonth() +1));// 월
//                tvDay.setText(""+dPicker1.getDayOfMonth());// 일
//
//                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));//시
//                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));//분
//            }
//        });

        tvYear.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                chrono.stop();
                chrono.setTextColor(Color.BLUE);

                tvYear.setText(Integer.toString(dPicker1.getYear()));//년
                tvMonth.setText(Integer.toString(dPicker1.getMonth() +1));// 월
                tvDay.setText(""+dPicker1.getDayOfMonth());// 일

                tvHour.setText(Integer.toString(tPicker.getCurrentHour()));//시
                tvMinute.setText(Integer.toString(tPicker.getCurrentMinute()));//분

                tPicker.setVisibility(View.INVISIBLE);
                dPicker1.setVisibility(View.INVISIBLE);
                rdoCal.setVisibility(View.INVISIBLE);
                rdoTime.setVisibility(View.INVISIBLE);

                return false;
            }
        });

//        calView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
//            @Override
//            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
//                selectYear =  year;
//                selectMonth = month + 1;
//                selectDay = dayOfMonth;
//            }
//        });

    }

}
