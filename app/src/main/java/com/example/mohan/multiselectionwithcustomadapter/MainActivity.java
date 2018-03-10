package com.example.mohan.multiselectionwithcustomadapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {

    private ListView listView;
    private Button button;
    private CustomAdapter adapter;
    private ArrayList<String> list = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listview);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        list.add("List 1");
        list.add("List 2");
        list.add("List 3");
        list.add("List 4");

        adapter = new CustomAdapter(MainActivity.this, list);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isSelected[] = adapter.getSelectedFlags();
                ArrayList<String> selectedItems = new ArrayList<String>();

                for (int i = 0; i < isSelected.length; i++) {
                    if (isSelected[i]) {
                        selectedItems.add(list.get(i));
                    }
                }

                Toast.makeText(MainActivity.this, "Selected: " + selectedItems, Toast.LENGTH_SHORT).show();
            }
        });

    }

}

