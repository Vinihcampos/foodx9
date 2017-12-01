package pso.secondphase.foodx9.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.model.Food;

/**
 * Created by vinihcampos on 30/11/17.
 */

public class GridViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<Food> foodList;

    public GridViewAdapter(Context mContext, List<Food> foodList){
        this.mContext = mContext;
        this.foodList = foodList;
    }

    @Override
    public int getCount() { return foodList.size(); }

    @Override
    public Object getItem(int position) { return foodList.get(position); }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View gridViewAndroid = inflater.inflate(R.layout.gridview_item, null);

        TextView price = (TextView) gridViewAndroid.findViewById(R.id.price_end);
        TextView priceCents = (TextView) gridViewAndroid.findViewById(R.id.price_end_cents);
        TextView foodTitle = (TextView) gridViewAndroid.findViewById(R.id.food_title);
        TextView foodRequest = (TextView) gridViewAndroid.findViewById(R.id.food_request);
        ImageView foodImage = (ImageView) gridViewAndroid.findViewById(R.id.food_image);

        //price.setText( String.valueOf( foodList.get(position).getPrice().intValue() ) );
        //priceCents.setText( String.valueOf( foodList.get(position).getPrice() - foodList.get(position).getPrice().intValue() ) );

        foodImage.setImageResource( foodList.get(position).getImage() );

        return gridViewAndroid;
    }
}
