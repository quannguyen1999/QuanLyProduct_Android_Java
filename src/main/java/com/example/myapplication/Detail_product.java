package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.models.Product;

public class Detail_product extends AppCompatActivity {
    ImageView imgView;
    TextView txtName, txtContent, txtPrice;

    private static final int VIEW = 888;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_product);

        txtName= findViewById(R.id.txtName);

        txtContent = findViewById(R.id.txtContent);

        txtPrice = findViewById(R.id.txtPrice);

        imgView = findViewById(R.id.imageView);

        Intent intent = getIntent();
        if(intent.hasExtra("view")){
            final Bundle bundle = intent.getBundleExtra("view");
            final Product product = (Product) bundle.getSerializable("product");
            txtName.setText(product.getName());
            txtContent.setText(product.getContent());
            txtPrice.setText(String.valueOf(product.getPrice())+" $");
            imgView.setImageResource(product.getImage());
        }
    }


}