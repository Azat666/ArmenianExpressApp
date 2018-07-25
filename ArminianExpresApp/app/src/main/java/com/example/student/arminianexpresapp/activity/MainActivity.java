package com.example.student.arminianexpresapp.activity;

import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.student.arminianexpresapp.R;
import com.example.student.arminianexpresapp.fragment.ExpresFragment;
import com.example.student.arminianexpresapp.models.ProduktModel;
import com.example.student.arminianexpresapp.proviader.UserProvider;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ExpresFragment expresFragment;
    private boolean a = true;
    public static int i = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getUpdate();
        expresFragment = new ExpresFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.conteiner, expresFragment).addToBackStack(null).commit();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final FloatingActionButton fab = findViewById(R.id.fab);
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ExpresFragment.listEF = UserProvider.returnFavorites();
                        expresFragment.updateAdapter();
                    }
                });
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem search = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                expresFragment.produktAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                expresFragment.produktAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        switch (id) {
            case R.id.nav_All:
                ExpresFragment.listEF = UserProvider.list;
                expresFragment.updateAdapter();
                break;
            case R.id.nav_watch:
                ExpresFragment.listEF = UserProvider.returnByType("Whach");
                expresFragment.updateAdapter();
                break;
            case R.id.nav_smartphone:
                ExpresFragment.listEF = UserProvider.returnByType("SmartPhone");
                expresFragment.updateAdapter();
                break;
            case R.id.nav_computer:
                ExpresFragment.listEF = UserProvider.returnByType("Notebook");
                expresFragment.updateAdapter();
                break;
            case R.id.nav_favorite:
                ExpresFragment.listEF = UserProvider.returnFavorites();
                expresFragment.updateAdapter();
                break;
            case R.id.nav_card:
                ExpresFragment.listEF = UserProvider.returnInBasket();
                expresFragment.updateAdapter();
                break;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getUpdate() {
        if (a) {
            int[] array = new int[3];
            array[0] = R.drawable.ifon51;
            array[1] = R.drawable.ifon52;
            array[2] = R.drawable.ifon53;
            UserProvider.list.add(new ProduktModel("Ifone 5s", array, R.string.ip5s_desc, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4", 0, "SmartPhone"));
            int[] array1 = new int[3];
            array1[0] = R.drawable.sm1;
            array1[1] = R.drawable.sm2;
            array1[2] = R.drawable.sm3;
            UserProvider.list.add(new ProduktModel("Samusng", array1, R.string.samsung, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4", 0, "Notebook"));
            int[] array2 = new int[3];
            array2[0] = R.drawable.rol1;
            array2[1] = R.drawable.rol2;
            array2[2] = R.drawable.rol3;
            UserProvider.list.add(new ProduktModel("Rolex", array2, R.string.rloex, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", 0, "Whach"));
            int[] array3 = new int[3];
            array3[0] = R.drawable.s81;
            array3[1] = R.drawable.s82;
            array3[2] = R.drawable.s833;
            UserProvider.list.add(new ProduktModel("Samsung S8", array3, R.string.samsungs8, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/WeAreGoingOnBullrun.mp4", 0, "SmartPhone"));
            int[] array4 = new int[3];
            array4[0] = R.drawable.ifonex1;
            array4[1] = R.drawable.ifx2;
            array4[2] = R.drawable.ifx3;
            UserProvider.list.add(new ProduktModel("Ifone X", array4, R.string.ifonX, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/TearsOfSteel.mp4", 0, "SmartPhone"));
            int[] array5 = new int[3];
            array5[0] = R.drawable.wh1;
            array5[1] = R.drawable.wh2;
            array5[2] = R.drawable.wh3;
            UserProvider.list.add(new ProduktModel("Apple", array5, R.string.apple, "https://s3.amazonaws.com/androidvideostutorial/862017385.mp4", 0, "Whach"));
            int[] array6 = new int[3];
            array6[0] = R.drawable.hp1;
            array6[1] = R.drawable.hp2;
            array6[2] = R.drawable.hp3;
            UserProvider.list.add(new ProduktModel("Hp", array6, R.string.hp, "https://storage.media.ext.hp.com/homepage/elitebook800-ambient.mp4", 0, "Notebook"));
            int[] array7 = new int[3];
            array7[0] = R.drawable.mac1;
            array7[1] = R.drawable.mac2;
            array7[2] = R.drawable.mac3;
            UserProvider.list.add(new ProduktModel("Apple Mac", array7, R.string.mac, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerBlazes.mp4", 0, "Notebook"));
            int[] array8 = new int[3];
            array8[0] = R.drawable.nikalay;
            array8[1] = R.drawable.nialayo;
            array8[2] = R.drawable.nikaylo;
            UserProvider.list.add(new ProduktModel("Nikolay", array8, R.string.nikolay, "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerEscapes.mp4", 0, "Whach"));
            a = false;
        }
    }


}
