package com.example.recipe_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FoodData> mFoodList;
    FoodData mFoodData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycler);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(MainActivity.this,1);
        recyclerView.setLayoutManager(gridLayoutManager);
        mFoodList=new ArrayList<>();
        mFoodData=new FoodData("Pizza","This is Chicken Pizza",
                "Rs.340",R.drawable.pizza);
        mFoodList.add(mFoodData);
        mFoodData=new FoodData("Chicken Pizza","This is Hot Chicken Pizza",
                "Rs.600",R.drawable.pizza2);
        mFoodList.add(mFoodData);
        mFoodData=new FoodData("Hot Pizza","This is Cheese Chicken Pizza",
                "Rs.440",R.drawable.pizza3);
        mFoodList.add(mFoodData);
        MyAdapter myAdapter=new MyAdapter(MainActivity.this,mFoodList);
        recyclerView.setAdapter(myAdapter);
    }
}