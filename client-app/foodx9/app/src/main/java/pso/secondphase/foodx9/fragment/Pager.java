package pso.secondphase.foodx9.fragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by vinihcampos on 01/12/17.
 */

public class Pager extends FragmentPagerAdapter {

    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                TabMealFragment tab1 = new TabMealFragment();
                return tab1;
            case 1:
                TabDrinkFragment tab2 = new TabDrinkFragment();
                return tab2;
            case 2:
                TabDessertFragment tab3 = new TabDessertFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        //this is where you set the titles
        switch(position) {
            case 0:
                return "Meals";
            case 1:
                return "Drinks";
            case 2:
                return "Desserts";
            default:
                return "NOT";
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
