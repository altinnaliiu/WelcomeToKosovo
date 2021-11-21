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

public class Culture extends AppCompatActivity {
    TextView detailsText;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.culture);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//a
        detailsText=findViewById(R.id.details);

        layout=findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://i.ibb.co/J7GzfSy/kultura1.jpg","Orendit"));
        slideModels.add(new SlideModel("https://i.ibb.co/Yt6Ksk3/kultura2.jpg","Fli"));
        slideModels.add(new SlideModel("https://i.ibb.co/hssZG7S/kultura3.jpg","Oda"));
        imageSlider.setImageList(slideModels,true);

    }
    //metode per hide text
    public void expand(View view) {
        int v=(detailsText.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        detailsText.setVisibility(v);
    }
}