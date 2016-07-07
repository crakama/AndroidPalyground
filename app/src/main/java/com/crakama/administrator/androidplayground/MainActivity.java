package com.crakama.administrator.androidplayground;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    private final int MENU_DOWNLOAD = 1;
    private final int MENU_SETTINGS = 2;
    private boolean showDownloadMenu = false;

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



    }//End of onCreate()
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_DOWNLOAD, 0, R.string.menu_download);
        menu.add(0, MENU_SETTINGS, 0, R.string.menu_settings);
        return true;
    }
    public void toggleMenu(View view) {
        showDownloadMenu=!showDownloadMenu;
    }
}//End of Class
