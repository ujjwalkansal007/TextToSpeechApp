package com.example.texttospeechapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    Button btn1,btn2,btn3;
    String[] names;
    TextView textView;
    int[] images;
    String[] imageNames;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView=findViewById(R.id.imageView);
        btn1=findViewById(R.id.prev);
        btn2=findViewById(R.id.speak);
        btn3=findViewById(R.id.next);
        textView=findViewById(R.id.texView);

        images= new int[]{
           R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g,
                R.drawable.h,R.drawable.i,R.drawable.j,R.drawable.k,R.drawable.l,R.drawable.m,R.drawable.n,
                R.drawable.o,R.drawable.p,R.drawable.q,R.drawable.r,R.drawable.s,R.drawable.t,R.drawable.u,
                R.drawable.v,R.drawable.w,R.drawable.x,R.drawable.y,R.drawable.z } ;

        imageNames= new String[]{"A is for... Apple","B is for... Boy","C is for... Cat","D is for... Dog",
                "E is for... Elephant","F is for... Fish","G is for... Goat","H is for... Hen","I is for... Icecream",
        "J is for... Jelly","K is for... Kite","L is for... Lion","M is for Monkey","N is for... Nose","O is for... Orange",
        "P is for... Parrot","Q is for...Queen","R is for... Rat","S is for... Sheep","T is for...Toy","U is for... Umbrella"
        ,"V is for... Van","W is for Watch","X is for Xylophone","Y is for Yak","Z is for Zebra"};


        String tag = String.valueOf(imageView.getTag());

        textView.setText("A for Apple");
        imageView.setImageResource(R.drawable.a);

        textToSpeech =new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!= TextToSpeech.ERROR){
                    textToSpeech.setLanguage(Locale.getDefault());
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int tag = String.valueOf(imageView.getTag()).charAt(0)-'A';
                 int next=(tag+1)%26;
                 imageView.setTag(""+(char)(next+'A'));
                 imageView.setImageResource(images[next]);
                 textView.setText(imageNames[next]);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int tag = String.valueOf(imageView.getTag()).charAt(0)-'A';
                int next=(tag+25)%26;
                imageView.setTag(""+(char)(next+'A'));
                imageView.setImageResource(images[next]);
                textView.setText(imageNames[next]);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tag = String.valueOf(imageView.getTag()).charAt(0)-'A';
                String text= imageNames[tag];
                textToSpeech.speak(text,TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }

}