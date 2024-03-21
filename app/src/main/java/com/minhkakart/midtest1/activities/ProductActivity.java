package com.minhkakart.midtest1.activities;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.minhkakart.midtest1.R;
import com.minhkakart.midtest1.adapter.ProductAdapter;
import com.minhkakart.midtest1.models.ProductModel;

import java.util.ArrayList;
import java.util.List;

public class ProductActivity extends AppCompatActivity {

    List<ProductModel> productModelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initTestData();
        RecyclerView recyclerView = findViewById(R.id.recycler_view_product);
        recyclerView.setAdapter(new ProductAdapter(productModelList, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    void initTestData(){
        productModelList = new ArrayList<>();
        productModelList.add(new ProductModel(1, "Product 1", "Description 1", 100, "ss_0"));
        productModelList.add(new ProductModel(2, "Product 2", "Description 2", 200, "ss_1"));
        productModelList.add(new ProductModel(3, "Product 3", "Description 3", 300, "ss_2"));
        productModelList.add(new ProductModel(4, "Product 4", "Description 4", 400, "ss_3"));
        productModelList.add(new ProductModel(5, "Product 5", "Description 5", 500, "ss_4"));
    }
}