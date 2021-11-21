package com.example.welcometokosova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView gridView;
    String[] names = {"Kosova","Turizem","Kulture","Contact Us"};
    int[] images = {R.drawable.kosovo,R.drawable.hiking,R.drawable.oda,R.drawable.feedback};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridView);
        CustomAdapter customAdapter=new CustomAdapter(names,images,this);
        gridView.setAdapter(customAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                if(i==0) {
                    Intent intent = new Intent(MainActivity.this, Informata.class);
                    startActivity(intent);
                }
                else if(i==1)
                {
                    Intent intent = new Intent(MainActivity.this, Hiking.class);
                    startActivity(intent);

                }
                else if(i==2)
                {
                    Intent intent = new Intent(MainActivity.this, Culture.class);
                    startActivity(intent);

                }
                else if(i==3)
                {
                    Intent intent = new Intent(MainActivity.this, Feedback.class);
                    startActivity(intent);

                }
            }
        });

    }
    public class CustomAdapter extends BaseAdapter {
        private String[] imagesNames;
        private int[] imagesPhoto;
        private Context context;
        private LayoutInflater layoutInflater;

        public CustomAdapter(String[] imagesNames, int[] imagesPhoto, Context context) {
            this.imagesNames = imagesNames;
            this.imagesPhoto = imagesPhoto;
            this.context = context;
            this.layoutInflater=(LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return imagesPhoto.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            if(view==null){
                view=layoutInflater.inflate(R.layout.row_items,viewGroup,false);
            }
            TextView tvName=view.findViewById(R.id.tvName);
            ImageView imageView=view.findViewById(R.id.imageView);
             tvName.setText(imagesNames[i]);
            imageView.setImageResource(imagesPhoto[i]);
            return view;
        }
    }
}