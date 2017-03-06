package com.example.androiddevelopment.zadatak20glumac.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.androiddevelopment.zadatak20glumac.R;
import com.example.androiddevelopment.zadatak20glumac.adapters.DrawerAdapter;
import com.example.androiddevelopment.zadatak20glumac.db.DatabaseHelper;
import com.example.androiddevelopment.zadatak20glumac.db.model.Glumac;
import com.example.androiddevelopment.zadatak20glumac.dialogs.AboutDialog;
import com.example.androiddevelopment.zadatak20glumac.dialogs.KontaktGialog;
import com.example.androiddevelopment.zadatak20glumac.model.NavigationItem;
import com.example.androiddevelopment.zadatak20glumac.provajderi.glumacProvajder;
import com.j256.ormlite.android.apptools.OpenHelperManager;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends AppCompatActivity {

    private class DrawerItemClickListener implements ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItemFromDrawer(position);
        }
    }

    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private RelativeLayout drawerPane;
    private CharSequence drawerTitle;
    private ArrayList<NavigationItem> drawerItems = new ArrayList<NavigationItem>();

    private AlertDialog dialog;
    private AlertDialog kdialog;
    private int itemId = 0;


    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

       // refresh1();


        drawerItems.add(new NavigationItem(getString(R.string.drawer_home), getString(R.string.drawer_home_long), R.drawable.ic_action_product));
        drawerItems.add(new NavigationItem(getString(R.string.drawer_settings), getString(R.string.drawer_settings_long), R.drawable.ic_action_settings));
        drawerItems.add(new NavigationItem(getString(R.string.drawer_about), getString(R.string.drawer_about_long), R.drawable.ic_action_about));
        drawerItems.add(new NavigationItem("Kontakt", "Podaci o udruženju", R.drawable.ic_action_contact));
        drawerItems.add(new NavigationItem("O autoru", "Ko je tvorac svega spomenutog", R.drawable.ic_action_autor));


        drawerTitle = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawerList = (ListView) findViewById(R.id.navList);

        // Populates NavigtionDrawer with options
        drawerPane = (RelativeLayout) findViewById(R.id.drawerPane);
        DrawerAdapter adapter = new DrawerAdapter(this, drawerItems);

        // Sets a custom shadow that overlays the main content when NavigationDrawer opens
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setAdapter(adapter);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }

        drawerToggle = new ActionBarDrawerToggle(
                this,                           /* host Activity */
                drawerLayout,                   /* DrawerLayout object */
                toolbar,                        /* nav drawer image to replace 'Up' caret */
                R.string.drawer_open,           /* "open drawer" description for accessibility */
                R.string.drawer_close           /* "close drawer" description for accessibility */
        ) {
            public void onDrawerClosed(View view) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
            }

            public void onDrawerOpened(View drawerView) {
                getSupportActionBar().setTitle(drawerTitle);
                invalidateOptionsMenu();        // Creates call to onPrepareOptionsMenu()
                drawerList.bringToFront();
                drawerLayout.requestLayout();
            }
        };
        refresh1();
    }







    // Method(s) that manage Toolbar.

    // onCreateOptionsMenu method initialize the contents of the Activity's Toolbar.
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // onOptionsItemSelected method is called whenever an item in the Toolbar is selected.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_create:
                addItem();
                Toast.makeText(this, "Opcija unos novog glumca pokrenuta", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_update:
                refresh1 ();
                Toast.makeText(this, "Osvezavanje liste glumaca!!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_delete:
                Toast.makeText(this, "Action " + getString(R.string.fragment_detal_action_delete) + " executed.", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    // Method(s) that manage NavigationDrawer.

    // onPostCreate method is called ofthen onRestoreInstanceState to synchronize toggle state
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }

    // onConfigurationChanged method is called when the device configuration changes to pass configuration change to the drawer toggle
    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);

        // Pass any configuration change to the drawer toggle
        drawerToggle.onConfigurationChanged(configuration);
    }

    // selectItemFromDrawer method is called when NavigationDrawer item is selected to update UI accordingly
    private void selectItemFromDrawer(int position) {


        switch(position){
            case(0):
                Toast toast = Toast.makeText(getBaseContext(), "Prva opcija izabrana", Toast.LENGTH_SHORT);
                toast.show();
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekoneimar.com"));
                startActivity(i);

            case(1):
                Toast toast1 = Toast.makeText(getBaseContext(), "Druga opcija izabrana", Toast.LENGTH_SHORT);
                toast1.show();

                Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekoneimar.com/fleksibilni-smestaj/"));
                startActivity(a);
            case(2):
                Toast toast2 = Toast.makeText(getBaseContext(), "Treca opcija izabrana", Toast.LENGTH_SHORT);
                toast2.show();
                if (dialog == null){
                    dialog = new AboutDialog(FirstActivity.this).prepareDialog();
                }
                else {
                    if (dialog.isShowing()) {
                        dialog.dismiss();
                    }
                }
                dialog.show();
            case(3):
                Toast toast3 = Toast.makeText(getBaseContext(), "Cetvrta opcija izabrana", Toast.LENGTH_SHORT);
                toast3.show();

                if (kdialog == null){
                    kdialog = new KontaktGialog(FirstActivity.this).prepareDialog();
                }
                else {
                    if (kdialog.isShowing()) {
                        kdialog.dismiss();
                    }
                }
                kdialog.show();


        }



        /*
        if (position == 0) {

            Toast toast = Toast.makeText(getBaseContext(), "Prva opcija izabrana", Toast.LENGTH_SHORT);
            toast.show();
            Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekoneimar.com"));
            startActivity(i);
        } else if (position == 1) {
            Toast toast = Toast.makeText(getBaseContext(), "Druga opcija izabrana", Toast.LENGTH_SHORT);
            toast.show();

            Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ekoneimar.com/fleksibilni-smestaj/"));
            startActivity(a);
        } else if (position == 2) {

            Toast toast = Toast.makeText(getBaseContext(), "Treca opcija izabrana", Toast.LENGTH_SHORT);
            toast.show();
            if (dialog == null){
                dialog = new AboutDialog(FirstActivity.this).prepareDialog();
            }
            else {
                if (dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
            dialog.show();
        }


        else if (position == 3) {
            Toast toast = Toast.makeText(getBaseContext(), "Cetvrta opcija izabrana", Toast.LENGTH_SHORT);
            toast.show();

            if (kdialog == null){
                kdialog = new KontaktGialog(FirstActivity.this).prepareDialog();
            }
            else {
                if (kdialog.isShowing()) {
                    kdialog.dismiss();
                }
            }
            kdialog.show();
        }


*/



       /* drawerList.setItemChecked(position, true);
        setTitle(drawerItems.get(position).getTitle());
       drawerLayout.closeDrawer(drawerPane);
        */


    }

    public void addItem( )  {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_layout);

        final Spinner imageSpinner= (Spinner) dialog.findViewById(R.id.glumac_image);
        List<String> imageList = new ArrayList<String>();
        imageList.add("ckalja.jpg");
        imageList.add("djuza.jpg");
        imageList.add("nikola.jpg");
        imageList.add("paja.jpg");
        ArrayAdapter<String> imagesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, imageList);
        imageSpinner.setAdapter(imagesAdapter);
        imageSpinner.setSelection(0);

        final EditText glumacName = (EditText) dialog.findViewById(R.id.glumac_name);
        final EditText glumacDescr = (EditText) dialog.findViewById(R.id.glumac_description);
        final EditText glumacRating = (EditText) dialog.findViewById(R.id.glumac_rating);

        Button ok = (Button) dialog.findViewById(R.id.ok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= glumacName.getText().toString();
                String desct= glumacDescr.getText().toString();
                //String rating=glumacRating.getText().toString();
                String image= (String) imageSpinner.getSelectedItem();

                Glumac glumac = new Glumac();
                glumac.setName(name);
                glumac.setDescribe(desct);
               // glumac.setRating(rating);
                glumac.setImage(image);



                try {
                    getDatabaseHelper().getGlumacDao().create(glumac);
                        refresh();
                    Toast.makeText(FirstActivity.this,"Glumac inserted!", Toast.LENGTH_SHORT).show();
                } catch (SQLException e) {
                    e.printStackTrace();
                }



            }
        });



        Button cancel = (Button) dialog.findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
           dialog.show();

    }

    public DatabaseHelper getDatabaseHelper() {
        if (databaseHelper == null) {
            databaseHelper = OpenHelperManager.getHelper(this, DatabaseHelper.class);
        }
        return databaseHelper;
    }
//----------------------------------Simin za assignment 25----------------------------

    private void refresh() {
        ListView listview = (ListView) findViewById(R.id.listaGlumaca);

        if (listview != null){
            ArrayAdapter<Glumac> adapter = (ArrayAdapter<Glumac>) listview.getAdapter();

            if(adapter!= null)
            {
                try {
                    adapter.clear();
                    List<Glumac> list = getDatabaseHelper().getGlumacDao().queryForAll();

                    adapter.addAll(list);

                    adapter.notifyDataSetChanged();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
//-------------------  refresh1 -------------orginalni koji radi------------------------------------
    private void refresh1() {
        final List<String> imenaGlumaca= glumacProvajder.getImenaGlumaca();


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, R.layout.list_item, imenaGlumaca);
        ListView listView = (ListView) findViewById(R.id.listaGlumaca);

        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);


            }

        });

    }






}
