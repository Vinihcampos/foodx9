package pso.secondphase.foodx9.activity;

import android.app.Activity;

import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.adapter.CustomRecyclerViewAdapter;
import pso.secondphase.foodx9.fragment.NavigationDrawerFragment;
import pso.secondphase.foodx9.model.Food;

public class MenuActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

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

    private List<Food> foods;
    private CustomRecyclerViewAdapter viewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        getActionBar().hide();

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

        foods = populateFoods();
        RecyclerView rv = (RecyclerView) findViewById(R.id.recyler_view);
        int numberOfColumns = 2;
        rv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        viewAdapter = new CustomRecyclerViewAdapter(this, foods);
        rv.setAdapter(viewAdapter);
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
