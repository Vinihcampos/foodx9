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

public class TabDessertFragment extends Fragment {

    private List<Food> foods;
    private CustomRecyclerViewAdapter viewAdapter;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        foods = populateFoods();
        View v = inflater.inflate(R.layout.tab_dessert, container, false);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.dessert);
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

        newFoods.add(new Food("birthday_cake", "", 99.99, R.drawable.birthday_cake));
        newFoods.add(new Food("biscuit", "", 99.99, R.drawable.biscuit));
        newFoods.add(new Food("chocolate_1", "", 99.99, R.drawable.chocolate_1));
        newFoods.add(new Food("chocolate_2", "", 99.99, R.drawable.chocolate_2));
        newFoods.add(new Food("chocolate", "", 99.99, R.drawable.chocolate));
        newFoods.add(new Food("cupcake", "", 99.99, R.drawable.cupcake));
        newFoods.add(new Food("donut", "", 99.99, R.drawable.donut));
        newFoods.add(new Food("honey", "", 99.99, R.drawable.honey));
        newFoods.add(new Food("icecream", "", 99.99, R.drawable.icecream));
        newFoods.add(new Food("jam", "", 99.99, R.drawable.jam));
        newFoods.add(new Food("jelly", "", 99.99, R.drawable.jelly));
        newFoods.add(new Food("pie", "", 99.99, R.drawable.pie));
        newFoods.add(new Food("watermelon", "", 99.99, R.drawable.watermelon));


        return newFoods;

    }

}
