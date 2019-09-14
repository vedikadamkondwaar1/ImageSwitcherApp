package com.example.imageswitcherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewSwitcher;

public class MainActivity extends AppCompatActivity {
    ImageSwitcher imageSwitcher;
    Button button;
    int imageIds[] = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d};
    int count = imageIds.length;
    int currentIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageSwitcher=findViewById(R.id.switcher);
        button=findViewById(R.id.buttonNext);
        //set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                //create a new image view and set its properties
                ImageView imageView = new ImageView(getApplicationContext());
                //set scale type image view to fill parent
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                //set the height and width of imageview to fill parent
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });
        //declare in and out animations and load them using animationutils class
        Animation in= AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
        Animation out= AnimationUtils.loadAnimation(this,android.R.anim.slide_out_right);
        //set the animation type of ImageSwitcher
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);
        //clicklisterner for next button
        //when clicked on button ImageSwitcher will switch between images
        //the current image ill go out and next image will come in with specified animation
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentIndex++;
                if (currentIndex == count)
                    currentIndex = 0;
                imageSwitcher.setImageResource(imageIds[currentIndex]);

            }
        });


    }

}
