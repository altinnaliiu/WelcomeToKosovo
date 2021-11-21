package com.example.welcometokosova;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Hiking extends AppCompatActivity {
    TextView detailsText;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hiking);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        detailsText=findViewById(R.id.details);

        layout=findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.panacomp.net/wp-content/uploads/2015/10/feataured-532484_2703094063501962084_n.jpg","Rugove"));
        slideModels.add(new SlideModel("https://www.ticati.com/img/hotel/3534425s.jpg","Brod, Dragash"));

        slideModels.add(new SlideModel("https://images.squarespace-cdn.com/content/v1/5be6ced8b105985523f1c051/1546872201693-F4X4ZZTLWCJHBF5EVKND/rugova-1.jpg","Liqenati"));
        slideModels.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/3/33/Rugova_Canyon.jpg","Gryka e Rugoves"));
        imageSlider.setImageList(slideModels,true);

    }
//metode per hide text
    public void expand(View view) {
        int v=(detailsText.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        detailsText.setVisibility(v);
    }
}