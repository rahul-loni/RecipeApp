package com.example.recipe_app;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<FoodViewHolder>{
       private Context mContext;
       private List<FoodData> myFoodData;

    public MyAdapter(Context mContext, List<FoodData> myFoodData) {
        this.mContext = mContext;
        this.myFoodData = myFoodData;
    }

    @Override
    public FoodViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View mView= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_items,parent,false );
        return new FoodViewHolder(mView);
    }

    @Override
    public void onBindViewHolder( FoodViewHolder holder, int position) {

        holder.imageView.setImageResource(myFoodData.get(position).getItmeImage());
        holder.item_name.setText(myFoodData.get(position).getItemName());
        holder.item_dis.setText(myFoodData.get(position).getItemDescription());
        holder.item_price.setText(myFoodData.get(position).getItemPrice());



    }

    @Override
    public int getItemCount() {
        return myFoodData.size();
    }
}
class FoodViewHolder extends RecyclerView.ViewHolder{

    TextView item_name,item_dis,item_price;
    ImageView imageView;
    CardView cardView;

    public FoodViewHolder(@NonNull View itemView) {
        super(itemView);

          item_name=itemView.findViewById(R.id.title);
          item_dis=itemView.findViewById(R.id.dis);
          item_price=itemView.findViewById(R.id.price);
          imageView=itemView.findViewById(R.id.image);
          cardView=itemView.findViewById(R.id.item_card);

    }
}
