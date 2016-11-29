package com.bwie.fragment.chuanzhi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.bwie.fragment.R;

public class FragmentActivity extends AppCompatActivity {

    private TextView fragment3_tv;
    private String[] mStrings = {"aaaaaa", "bbbbbbb", "ccccc", "ddddd", "eeeeee",
            "fffffff", "gggggg", "hhhhhh"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        ArrayAdapter arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, mStrings);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(arrayAdapter);

        fragment3_tv = (TextView) findViewById(R.id.fragment3_tv);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                fragment3_tv.setText(mStrings[position]);
            }
        });
    }
}
