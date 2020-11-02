package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.adapters.ListProductAdapter;
import com.example.myapplication.models.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  ClickItemInterface{
    private ListProductAdapter listProductAdapter;

    private RecyclerView rclView;

    private ArrayList<Product> listProduct;

    private EditText edtSearch;

    private ImageButton imageButton;

    private Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        metaData();

        initData();

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = edtSearch.getText().toString();
                if(text.isEmpty()){
                    final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Alert");
                    alert.setMessage("Please enter search food...");
                    alert.setNegativeButton("Ok", null);
                    alert.show();
                    edtSearch.requestFocus();
                }else{
                    ArrayList<Product> listProductFind = new ArrayList<>();
                    for (Product product : listProduct) {
                        if(product.getName().contentEquals(text)){
                            listProductFind.add(product);
                        }
                    }
                    if(listProductFind.size()<=0){
                        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("Alert");
                        alert.setMessage("Not found...");
                        alert.setNegativeButton("Ok", null);
                        alert.show();
                    }else{
                        ClickItemInterface clickItemInterface = new ClickItemInterface() {
                            @Override
                            public void onCLickItemTable(Product product) {
                                Intent intent = new Intent(MainActivity.this
                                        , Detail_product.class);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("product", product);
                                intent.putExtra("view",bundle);
                                startActivity(intent);
                            }
                        };
                        listProductAdapter = new ListProductAdapter(MainActivity.this
                                , listProductFind, clickItemInterface);

                        rclView.setAdapter(listProductAdapter);

                        rclView.setLayoutManager(new LinearLayoutManager(MainActivity.this){
                            @Override
                            public boolean requestChildRectangleOnScreen(@NonNull RecyclerView parent, @NonNull View child, @NonNull Rect rect, boolean immediate) {
                                return false;
                            }

                            @Override
                            public boolean requestChildRectangleOnScreen(@NonNull RecyclerView parent, @NonNull View child, @NonNull Rect rect, boolean immediate, boolean focusedChildVisible) {
                                return false;
                            }
                        });

                        rclView.setFocusable(false);
                    }

                }
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initData();
            }
        });

    }

    private void metaData() {
        rclView = findViewById(R.id.rclView);
        edtSearch = findViewById(R.id.edtSearchFood);
        imageButton = findViewById(R.id.imgBtn);
        btnReset = findViewById(R.id.btnReset);
    }

    private void initData() {
        listProduct = new ArrayList<>();

        listProduct.add(new Product("P101","Teasty Donut","Ngon",10,R.drawable.donut_yellow));
        listProduct.add(new Product("P102","Pink Donut","Ngon",10,R.drawable.donut_red));
        listProduct.add(new Product("P103","Black Donut","Ngon",10,R.drawable.green_donut));
        listProduct.add(new Product("P104","Shit Donut","Ngon",10,R.drawable.pink_donut));

        listProductAdapter = new ListProductAdapter(this, listProduct, this);

        rclView.setAdapter(listProductAdapter);

        rclView.setLayoutManager(new LinearLayoutManager(this){
            @Override
            public boolean requestChildRectangleOnScreen(@NonNull RecyclerView parent, @NonNull View child, @NonNull Rect rect, boolean immediate) {
                return false;
            }

            @Override
            public boolean requestChildRectangleOnScreen(@NonNull RecyclerView parent, @NonNull View child, @NonNull Rect rect, boolean immediate, boolean focusedChildVisible) {
                return false;
            }
        });

        rclView.setFocusable(false);
    }

    @Override
    public void onCLickItemTable(Product product) {
        Intent intent = new Intent(this, Detail_product.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", product);
        intent.putExtra("view",bundle);
        startActivity(intent);
    }
}