package pso.secondphase.foodx9.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.adapter.CustomRecyclerViewAdapter;
import pso.secondphase.foodx9.model.Food;
import pso.secondphase.foodx9.util.AutoFitGridLayoutManager;

/**
 * Created by vinihcampos on 01/12/17.
 */

public class TabMealFragment extends Fragment {

    private List<Food> foods;
    private CustomRecyclerViewAdapter viewAdapter;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        foods = populateFoods();

        View v = inflater.inflate(R.layout.tab_meal, container, false);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.meal);
        //rv.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        rv.setLayoutManager(new AutoFitGridLayoutManager(v.getContext(), 500));
        viewAdapter = new CustomRecyclerViewAdapter(v.getContext(), foods);
        rv.setAdapter(viewAdapter);

        //Returning the layout file after inflating
        //Change R.layout.tab1 in you classes
        return v;
    }

    private List<Food> populateFoods(){

        List<Food> newFoods = new ArrayList<>();

        newFoods.add(new Food("aubergine", "", 99.99, R.drawable.aubergine));
        newFoods.add(new Food("bread", "", 99.99, R.drawable.bread));
        newFoods.add(new Food("breakfast", "", 99.99, R.drawable.breakfast));
        newFoods.add(new Food("brochettes", "", 99.99, R.drawable.brochettes));
        newFoods.add(new Food("burger", "", 99.99, R.drawable.burger));
        newFoods.add(new Food("carrot", "", 99.99, R.drawable.carrot));
        newFoods.add(new Food("cheese", "", 99.99, R.drawable.cheese));
        newFoods.add(new Food("chicken_1", "", 99.99, R.drawable.chicken_1));
        newFoods.add(new Food("chicken", "", 99.99, R.drawable.chicken));
        newFoods.add(new Food("croissant", "", 99.99, R.drawable.croissant));
        newFoods.add(new Food("egg", "", 99.99, R.drawable.egg));
        newFoods.add(new Food("fish", "", 99.99, R.drawable.fish));
        newFoods.add(new Food("fries", "", 99.99, R.drawable.fries));
        newFoods.add(new Food("hot_dog", "", 99.99, R.drawable.hot_dog));
        newFoods.add(new Food("lettuce", "", 99.99, R.drawable.lettuce));
        newFoods.add(new Food("loaf", "", 99.99, R.drawable.loaf));
        newFoods.add(new Food("noodles", "", 99.99, R.drawable.noodles));
        newFoods.add(new Food("pepper", "", 99.99, R.drawable.pepper));
        newFoods.add(new Food("pickles", "", 99.99, R.drawable.pickles));
        newFoods.add(new Food("pizza", "", 99.99, R.drawable.pizza));
        newFoods.add(new Food("rice", "", 99.99, R.drawable.rice));
        newFoods.add(new Food("sausage", "", 99.99, R.drawable.sausage));
        newFoods.add(new Food("spaguetti", "", 99.99, R.drawable.spaguetti));
        newFoods.add(new Food("steak", "", 99.99, R.drawable.steak));

        return newFoods;

    }

}
