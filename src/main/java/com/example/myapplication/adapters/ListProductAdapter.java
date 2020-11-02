package com.example.myapplication.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.ClickItemInterface;
import com.example.myapplication.R;
import com.example.myapplication.models.Product;

import java.util.ArrayList;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.ProductViewHolder>{

    private LayoutInflater layoutInflater;

    private ArrayList<Product> listProduct;

    private ConstraintLayout constraintLayout;

    private int selectedItem = -1;

    ClickItemInterface clickItemInterface;

    public ListProductAdapter(Context context, ArrayList<Product> listProduct, ClickItemInterface clickItemInterface) {
        layoutInflater = LayoutInflater.from(context);
        this.listProduct = listProduct;
        this.clickItemInterface = clickItemInterface;
    }

    @NonNull
    @Override
    public ListProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View iItemView = layoutInflater.inflate(R.layout.list_product, parent, false);
        return new ProductViewHolder(iItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        Product mCurrent = listProduct.get(position);

        holder.txtName.setText(mCurrent.getName());
        holder.txtContent.setText(mCurrent.getContent());
        holder.txtPrice.setText(String.valueOf(mCurrent.getPrice())+" $");
        holder.imgView.setImageResource(mCurrent.getImage());

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                clickItemInterface.onCLickItemTable(listProduct.get(position));
                return true;
            }
        });

    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder{
        TextView txtName, txtContent, txtPrice;
        ImageView imgView;

        ConstraintLayout constraintLayout;

        ListProductAdapter listProductAdapter;

        public ProductViewHolder(@NonNull View itemView, ListProductAdapter listProductAdapter) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtContent = itemView.findViewById(R.id.txtContent);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            imgView = itemView.findViewById(R.id.imgView);
            constraintLayout = itemView.findViewById(R.id.ct);

            this.listProductAdapter = listProductAdapter;

        }
    }
}
