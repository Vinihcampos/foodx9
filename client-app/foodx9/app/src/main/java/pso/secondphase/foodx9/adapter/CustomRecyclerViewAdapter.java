package pso.secondphase.foodx9.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

import pso.secondphase.foodx9.R;
import pso.secondphase.foodx9.client.TCPconnection;
import pso.secondphase.foodx9.client.UDPconnection;
import pso.secondphase.foodx9.model.Food;

import static pso.secondphase.foodx9.activity.MenuActivity.TABLEQR;

/**
 * Created by vinihcampos on 01/12/17.
 */

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.ViewHolder> {
    private List<Food> mData;
    private LayoutInflater mInflater;

    public CustomRecyclerViewAdapter(Context mContext, List<Food> foods) {
        this.mInflater = LayoutInflater.from(mContext);
        this.mData = foods;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.gridview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomRecyclerViewAdapter.ViewHolder holder, int position) {
        Double price = mData.get(position).getPrice();
        holder.price.setText( String.valueOf( price.intValue() ) );
        holder.priceCents.setText( String.valueOf( (int) ((price - price.intValue()) * 100) ) );
        holder.foodTitle.setText( mData.get(position).getTitle() );
        holder.foodImage.setImageResource(mData.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView price = (TextView) itemView.findViewById(R.id.price_end);
        TextView priceCents = (TextView) itemView.findViewById(R.id.price_end_cents);
        TextView foodTitle = (TextView) itemView.findViewById(R.id.food_title);
        TextView foodRequest = (TextView) itemView.findViewById(R.id.food_request);
        ImageView foodImage = (ImageView) itemView.findViewById(R.id.food_image);

        ViewHolder(View itemView) {
            super(itemView);

            foodRequest.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                try {
                    UDPconnection.sendMsg(foodTitle.getText() + ";" + TABLEQR);
                    Toast.makeText(mInflater.getContext(), foodTitle.getText() + " ordered", Toast.LENGTH_SHORT).show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                }
            });
        }
    }

    // convenience method for getting data at click position
    String getItem(int id) {
        return mData.get(id).getTitle();
    }

}
