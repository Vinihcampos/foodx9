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

public class TabDrinkFragment extends Fragment {

    private List<Food> foods;
    private CustomRecyclerViewAdapter viewAdapter;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        foods = populateFoods();

        View v = inflater.inflate(R.layout.tab_drink, container, false);
        RecyclerView rv = (RecyclerView) v.findViewById(R.id.drink);
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

        newFoods.add(new Food("beer", "", 99.99, R.drawable.beer));
        newFoods.add(new Food("cocktail", "", 99.99, R.drawable.cocktail));
        newFoods.add(new Food("coffee", "", 99.99, R.drawable.coffee));
        newFoods.add(new Food("coke", "", 99.99, R.drawable.coke));
        newFoods.add(new Food("cupcake", "", 99.99, R.drawable.cupcake));
        newFoods.add(new Food("cup", "", 99.99, R.drawable.cup));
        newFoods.add(new Food("juice", "", 99.99, R.drawable.juice));
        newFoods.add(new Food("milk", "", 99.99, R.drawable.milk));
        newFoods.add(new Food("tea", "", 99.99, R.drawable.tea));
        newFoods.add(new Food("water_glass", "", 99.99, R.drawable.water_glass));
        newFoods.add(new Food("wine", "", 99.99, R.drawable.wine));


        return newFoods;

    }

}
