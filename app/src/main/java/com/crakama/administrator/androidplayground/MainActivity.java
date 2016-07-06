package com.crakama.administrator.androidplayground;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    //  setContentView(R.layout.activity_main);
        String[] countries = new String[] {"Kenya","Uganda","Tanzania","South Sudan" ,"Rwanda"};

        ListAdapter countryAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_activated_1,countries);
        setListAdapter(countryAdapter);


        getListView().setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String s = ((TextView) view).getText() + " " +
                                position;
                        Toast.makeText(getApplicationContext(), s,
                                Toast.LENGTH_SHORT).show();
                    }
                });


    }
}
