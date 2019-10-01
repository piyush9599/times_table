package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTablelistview;
    public void generatenumber(int timestablenumber){
        ArrayList<String> timestablecontent = new ArrayList<String>();
        for(int j=1;j<=10;j++){
            timestablecontent.add(Integer.toString(j*timestablenumber));
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timestablecontent);
        timesTablelistview.setAdapter(adapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       final SeekBar seekBar= findViewById(R.id.timesTableseekbar);
        timesTablelistview = findViewById(R.id.timesTablelistview);
        int max = 20;
        int progress=10;
        seekBar.setMax(max);
        seekBar.setProgress(progress);
        generatenumber(progress);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int timestablenumber;
                if(i<min){
                    timestablenumber=min;
                    seekBar.setProgress(min);

                }else{
                    timestablenumber=i;
                }
                Log.d("msg",Integer.toString(timestablenumber));
                generatenumber(timestablenumber);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
