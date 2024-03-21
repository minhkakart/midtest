package com.minhkakart.midtest1.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minhkakart.midtest1.R;
import com.minhkakart.midtest1.models.ProductModel;
import com.minhkakart.midtest1.support.DrawableUri;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder>{
    List<ProductModel> productModelList;
    Context context;

    public ProductAdapter(List<ProductModel> productModelList, Context context) {
        this.productModelList = productModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_item, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        holder.bind(productModelList.get(position), context);
    }

    @Override
    public int getItemCount() {
        return productModelList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView productName, productPrice, productDescription;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.product_img);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productDescription = itemView.findViewById(R.id.product_description);
        }

        void bind(ProductModel productModel, Context context){
            Uri imgUri = DrawableUri.getDrawableUri(productModel.getImageName(), context);
            imageView.setImageURI(imgUri);
            productName.setText(productModel.getName());
            productPrice.setText(String.valueOf(productModel.getPrice()));
            productDescription.setText(productModel.getDescription());
        }
    }
}