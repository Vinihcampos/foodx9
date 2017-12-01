package pso.secondphase.foodx9.activity;

import android.Manifest;
import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.fragment.NavigationDrawerFragment;
import pso.secondphase.foodx9.fragment.Pager;
import pso.secondphase.foodx9.model.Food;

public class MenuActivity extends AppCompatActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks,
        TabLayout.OnTabSelectedListener {

    private Context context;
    private static final int PERMISSION_REQUEST_CODE = 1;

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    private DrawerLayout drawerLayout;

    private ImageView menuIcon;

    private TabLayout tabLayout;
    private ViewPager viewPager;

    public static String TABLEQR = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getApplicationContext();
        requestPermission();

        if (android.os.Build.VERSION.SDK_INT > 9){
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        setContentView(R.layout.activity_menu);
        getSupportActionBar().hide();

        Intent i = getIntent();
        TABLEQR = i.getStringExtra("TABLE");

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        mNavigationDrawerFragment.setUp( R.id.navigation_drawer, drawerLayout);
        menuIcon = (ImageView) findViewById(R.id.menu_button);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        //Initializing the tablayout
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method
        tabLayout.addTab(tabLayout.newTab().setText("Meals"));
        tabLayout.addTab(tabLayout.newTab().setText("Drinks"));
        tabLayout.addTab(tabLayout.newTab().setText("Desserts"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
        viewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        Pager adapter = new Pager(getSupportFragmentManager(), tabLayout.getTabCount());

        //Adding adapter to pager
        viewPager.setAdapter(adapter);
        tabLayout.setOnTabSelectedListener(this);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void requestPermission(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) {
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {
                Toast.makeText(context,"Camera permission",Toast.LENGTH_LONG).show();

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        PERMISSION_REQUEST_CODE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }

        }
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

    private List<Food> populateFoods(){

        List<Food> newFoods = new ArrayList<>();

        newFoods.add(new Food("aubergine", "", 99.99, R.drawable.aubergine));
        newFoods.add(new Food("beer", "", 99.99, R.drawable.beer));
        newFoods.add(new Food("birthday_cake", "", 99.99, R.drawable.birthday_cake));
        newFoods.add(new Food("biscuit", "", 99.99, R.drawable.biscuit));
        newFoods.add(new Food("bread", "", 99.99, R.drawable.bread));
        newFoods.add(new Food("breakfast", "", 99.99, R.drawable.breakfast));
        newFoods.add(new Food("brochettes", "", 99.99, R.drawable.brochettes));
        newFoods.add(new Food("burger", "", 99.99, R.drawable.burger));
        newFoods.add(new Food("carrot", "", 99.99, R.drawable.carrot));
        newFoods.add(new Food("cheese", "", 99.99, R.drawable.cheese));
        newFoods.add(new Food("chicken_1", "", 99.99, R.drawable.chicken_1));
        newFoods.add(new Food("chicken", "", 99.99, R.drawable.chicken));
        newFoods.add(new Food("chocolate_1", "", 99.99, R.drawable.chocolate_1));
        newFoods.add(new Food("chocolate_2", "", 99.99, R.drawable.chocolate_2));
        newFoods.add(new Food("chocolate", "", 99.99, R.drawable.chocolate));
        newFoods.add(new Food("cocktail", "", 99.99, R.drawable.cocktail));
        newFoods.add(new Food("coffee", "", 99.99, R.drawable.coffee));
        newFoods.add(new Food("coke", "", 99.99, R.drawable.coke));
        newFoods.add(new Food("covering", "", 99.99, R.drawable.covering));
        newFoods.add(new Food("croissant", "", 99.99, R.drawable.croissant));
        newFoods.add(new Food("cupcake", "", 99.99, R.drawable.cupcake));
        newFoods.add(new Food("cup", "", 99.99, R.drawable.cup));
        newFoods.add(new Food("donut", "", 99.99, R.drawable.donut));
        newFoods.add(new Food("egg", "", 99.99, R.drawable.egg));
        newFoods.add(new Food("fish", "", 99.99, R.drawable.fish));
        newFoods.add(new Food("fries", "", 99.99, R.drawable.fries));
        newFoods.add(new Food("honey", "", 99.99, R.drawable.honey));
        newFoods.add(new Food("hot_dog", "", 99.99, R.drawable.hot_dog));
        newFoods.add(new Food("icecream", "", 99.99, R.drawable.icecream));
        newFoods.add(new Food("jam", "", 99.99, R.drawable.jam));
        newFoods.add(new Food("jelly", "", 99.99, R.drawable.jelly));
        newFoods.add(new Food("juice", "", 99.99, R.drawable.juice));
        newFoods.add(new Food("ketchup", "", 99.99, R.drawable.ketchup));
        newFoods.add(new Food("lemon", "", 99.99, R.drawable.lemon));
        newFoods.add(new Food("lettuce", "", 99.99, R.drawable.lettuce));
        newFoods.add(new Food("loaf", "", 99.99, R.drawable.loaf));
        newFoods.add(new Food("milk", "", 99.99, R.drawable.milk));
        newFoods.add(new Food("noodles", "", 99.99, R.drawable.noodles));
        newFoods.add(new Food("pepper", "", 99.99, R.drawable.pepper));
        newFoods.add(new Food("pickles", "", 99.99, R.drawable.pickles));
        newFoods.add(new Food("pie", "", 99.99, R.drawable.pie));
        newFoods.add(new Food("pizza", "", 99.99, R.drawable.pizza));
        newFoods.add(new Food("rice", "", 99.99, R.drawable.rice));
        newFoods.add(new Food("sausage", "", 99.99, R.drawable.sausage));
        newFoods.add(new Food("spaguetti", "", 99.99, R.drawable.spaguetti));
        newFoods.add(new Food("steak", "", 99.99, R.drawable.steak));
        newFoods.add(new Food("tea", "", 99.99, R.drawable.tea));
        newFoods.add(new Food("water_glass", "", 99.99, R.drawable.water_glass));
        newFoods.add(new Food("watermelon", "", 99.99, R.drawable.watermelon));
        newFoods.add(new Food("wine", "", 99.99, R.drawable.wine));


        return newFoods;

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_menu, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MenuActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
