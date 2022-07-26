package com.example.piechart1;

// Import the required libraries
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button getData;
    PieChart piechart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getData = findViewById(R.id.getPieChart);
        piechart = findViewById(R.id.pieChart);
        showPieChart();
    }

    // method to handle piecharting
    public void showPieChart(){

        ArrayList<PieEntry> pieEntries =  new ArrayList <PieEntry>();
        String label = "type";

        //with the hashmap
        Map<String,Integer> typeAmountMap = new HashMap<>();
        //to add items to hashmap use the put method
      //  typeAmountMap.put(Names, testing);
        typeAmountMap.put("TVs ", 20);
        typeAmountMap.put("Printers", 30);
        typeAmountMap.put("Phones", 14);
        typeAmountMap.put("Speakers", 19);


        //put the color options into the array
        ArrayList<Integer> colors  = new ArrayList<>();
        colors.add(Color.parseColor("#E5FFCC"));
        colors.add(Color.parseColor("#FFE5CC"));
        colors.add(Color.parseColor("#A0A0A0"));
        colors.add(Color.parseColor("#CCFFCC"));
        colors.add(Color.parseColor("#606060"));
        colors.add(Color.parseColor("#CC0000"));


        // input the data and fit into the pie chart
        for (String type: typeAmountMap.keySet()){
            pieEntries.add(new PieEntry(typeAmountMap.get(type).floatValue(),type));
        }
        // collections  with the label names
        PieDataSet pieDataSet = new PieDataSet(pieEntries,label);
        //set text size
        pieDataSet.setValueTextSize(10f);
        //parse color list
        pieDataSet.setColors(colors);
        //grouping the data
        PieData pieData = new PieData(pieDataSet);
        //showing the value  of the entries defualt true if not set
        pieData.setDrawValues(true);

        piechart.setData(pieData);
        piechart.invalidate();
    }

}
