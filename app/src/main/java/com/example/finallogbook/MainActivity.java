package com.example.finallogbook;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    List<String> arrlist
            = new ArrayList<>();
    static Integer currentNum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button prev = findViewById(R.id.prev);
        Button next = findViewById(R.id.next);
        Button add = findViewById(R.id.add);
        ImageView imageView = findViewById(R.id.imageView);
        EditText editText = findViewById(R.id.text);

        arrlist.add("https://images.pexels.com/photos/45201/kitty-cat-kitten-pet-45201.jpeg?cs=srgb&dl=pexels-pixabay-45201.jpg&fm=jpg");
        arrlist.add("https://media.istockphoto.com/photos/grey-stripped-mixedbreed-cat-sitting-isolated-on-white-picture-id1217828258?k=20&m=1217828258&s=612x612&w=0&h=2qMM0y95RyJm0f_CyTYjm-MqDrwNLrApsdxaarb5prg=");

        add.setOnClickListener(view -> {
            String url = editText.getText().toString();
            arrlist.add(url);
        });

        Picasso.with(this)
                .load(arrlist.get(currentNum))
                .into(imageView);

        prev.setOnClickListener(view -> {
            if (currentNum - 1 >= 0) {
                currentNum = currentNum - 1;
            }

            Toast.makeText(this, "Currrent Num " + currentNum, Toast.LENGTH_SHORT).show();
                Log.e("Prev", "Prev");
                Picasso.with(this)
                        .load(arrlist.get(currentNum))
                        .into(imageView);
        });

        next.setOnClickListener(view -> {
            Integer count = currentNum + 1;
            if (count <= arrlist.size()) {
                Log.e("Size arr", "Size" + arrlist.size());
                Log.e("Current", "Current" + currentNum);
                currentNum = currentNum + 1;
            }
            Toast.makeText(this, "Currrent Num " + currentNum, Toast.LENGTH_SHORT).show();
//
            if (currentNum < arrlist.size()) {
                Picasso.with(this)
                        .load(arrlist.get(currentNum))
                        .into(imageView);
            }

        });


    }
}