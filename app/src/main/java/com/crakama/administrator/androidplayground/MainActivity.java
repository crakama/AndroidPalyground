package com.crakama.administrator.androidplayground;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
    //   creating the menus using the Menu.add() method instead of inflating the XML file
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0, MENU_DOWNLOAD, 0, R.string.menu_download);
        menu.add(0, MENU_SETTINGS, 0, R.string.menu_settings);
        return true;
    }
    public void toggleMenu(View view) {
        showDownloadMenu=!showDownloadMenu;
    }

    //change the visibility of the Download menu item based on flag:
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem menuItem = menu.findItem(MENU_DOWNLOAD);
        menuItem.setVisible(showDownloadMenu);
        return true;
    }
    // Response to each menu item:
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case MENU_DOWNLOAD:
                Toast.makeText(this, R.string.menu_download,
                        Toast.LENGTH_LONG).show();
                break;
            case MENU_SETTINGS:
                Toast.makeText(this, R.string.menu_settings,
                        Toast.LENGTH_LONG).show();
                break;
            default:
                return super.onContextItemSelected(item);
        }
        return true;
    }
}//End of Class
