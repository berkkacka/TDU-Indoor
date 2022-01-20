package com.brk.tduindoor;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.brk.tduindoor.databinding.ActivityCalendarBinding;

import java.util.ArrayList;


public class CalendarActivity extends AppCompatActivity {
    Spinner spinner1, spinner2;

    ArrayList<String> arrayList_sgang;
    ArrayAdapter<String> arrayAdapter_sgang;
    ArrayList<Integer> calendar;
    ActivityCalendarBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding=ActivityCalendarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        loadData();

        binding.spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                binding.imgCal.setImageResource(calendar.get(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    public void loadData(){
        arrayList_sgang=new ArrayList<>();

        arrayList_sgang.add("INF-1");
        arrayList_sgang.add("INF-2");
        arrayList_sgang.add("INF-3");
        arrayList_sgang.add("INF-4");

        arrayAdapter_sgang=new ArrayAdapter<>(CalendarActivity.this, android.R.layout.simple_spinner_item,arrayList_sgang);
        binding.spinner1.setAdapter(arrayAdapter_sgang);


        calendar=new ArrayList<>();

        calendar.add(R.drawable.inf_1);
        calendar.add(R.drawable.inf_2);
        calendar.add(R.drawable.inf_3);
        calendar.add(R.drawable.d);
    }
}

























