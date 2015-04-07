package com.gov.dmrd.disastermanagement;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements TestFragment0.OnFragmentInteractionListener, TestFragment1.OnFragmentInteractionListener, TestFragment2.OnFragmentInteractionListener, TestFragment3.OnFragmentInteractionListener
        , TestFragment4.OnFragmentInteractionListener, TestFragment5.OnFragmentInteractionListener, TestFragment6.OnFragmentInteractionListener, TestFragment7.OnFragmentInteractionListener, TestFragment8.OnFragmentInteractionListener
        , TestFragment9.OnFragmentInteractionListener, PDFFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener
{
    public int current_position;
    String[] menu;
    DrawerLayout dLayout;
    ListView dList;
    ArrayAdapter<String> adapter;
    ActionBarDrawerToggle drawerToggle;
    Fragment myFragment;
    String fragmentName;
    FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle(R.string.app_name);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        menu = getResources().getStringArray(R.array.list_items);
        dLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        dList = (ListView) findViewById(R.id.left_drawer);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        dList.setAdapter(adapter);

        drawerToggle = new ActionBarDrawerToggle(this, dLayout, R.string.drawer_open, R.string.drawer_close)
        {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        dLayout.setDrawerListener(drawerToggle);
        dList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {
                v.setSelected(true);
                dList.setSelector(R.color.red);
                current_position = position;
                fragmentManager = getFragmentManager();
                if (position == 0) {
                    myFragment = new TestFragment0();
                } else if (position == 1) {
                    myFragment = new TestFragment1();
                } else if (position == 2) {
                    myFragment = new TestFragment2();
                } else if (position == 3) {
                    myFragment = new TestFragment3();
                } else if (position == 4) {
                    myFragment = new TestFragment4();
                } else if (position == 5) {
                    myFragment = new TestFragment5();
                } else if (position == 6) {
                    myFragment = new TestFragment6();
                } else if (position == 7) {
                    myFragment = new TestFragment7();
                } else if (position == 8) {
                    myFragment = new TestFragment8();
                } else if (position == 9) {
                    myFragment = new TestFragment9();
                } else if (position == 10) {
                    myFragment = new AboutFragment();
                }
                dList.setItemChecked(position, true);
                fragmentName = String.valueOf(position);
                fragmentManager.popBackStack();
                fragmentManager.beginTransaction().replace(R.id.content_frame, myFragment).addToBackStack(fragmentName).commit();
                getSupportActionBar().setTitle((String) arg0.getItemAtPosition(position));
                dLayout.closeDrawers();
                adapter.notifyDataSetChanged();
            }
        });
        drawerToggle.syncState();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        drawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onBackPressed() {

        //super.onBackPressed();
        AlertDialog.Builder ad1=new AlertDialog.Builder(this);
        ad1.setMessage(R.string.exit_question);
        ad1.setCancelable(false);


        ad1.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        ad1.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        AlertDialog alert=ad1.create();
        alert.show();

    }

}