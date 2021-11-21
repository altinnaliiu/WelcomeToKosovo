package com.example.welcometokosova;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import android.net.Uri;
import android.widget.MediaController;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class Informata extends AppCompatActivity {
    TextView detailsText;
    LinearLayout layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informata);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //video
        MediaController mediaController= new MediaController(this);

        VideoView simpleVideoView = (VideoView) findViewById(R.id.simpleVideoView);

        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));
        simpleVideoView.setMediaController(mediaController);




        detailsText=findViewById(R.id.details);
        layout=findViewById(R.id.layout);
        layout.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);


        //image slider
        ImageSlider imageSlider=findViewById(R.id.slider);
        List<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://insajderi.com/wp-content/uploads/2018/10/new_slider04.jpg","Hyjnesha ne fron"));
        slideModels.add(new SlideModel("https://scontent.fprn13-1.fna.fbcdn.net/v/t1.6435-9/128257834_3757090747676615_1521277119796031009_n.jpg?_nc_cat=109&ccb=1-5&_nc_sid=b9115d&_nc_ohc=fXZHV0qXAx0AX__EkkT&_nc_ht=scontent.fprn13-1.fna&oh=e72a67b419ccb8e4caf6ba12f769908e&oe=61BEA662","Prekazi legjendar"));

        slideModels.add(new SlideModel("https://upload.wikimedia.org/wikipedia/commons/7/7e/Newborn.jpg","Newborn"));
        imageSlider.setImageList(slideModels,true);

    }
    //metode per hide text
    public void expand(View view) {
        int v=(detailsText.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;

        TransitionManager.beginDelayedTransition(layout,new AutoTransition());
        detailsText.setVisibility(v);
    }
}