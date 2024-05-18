package com.example.tugaspraktikum2;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


    public class MainActivity3 extends AppCompatActivity {

        private TextView textView1;
        private TextView textView2;
        private TextView textView3;
        private TextView textView4;
        private ImageView image;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main3);

            textView1 = findViewById(R.id.nama);
            textView2 = findViewById(R.id.username);
            textView3 = findViewById(R.id.title);
            textView4 = findViewById(R.id.content);
            image = findViewById(R.id.imageView);

            String text1 = getIntent().getStringExtra("textFromEt1");
            String text2 = getIntent().getStringExtra("textFromEt2");
            String text3 = getIntent().getStringExtra("textFromEt3");
            String text4 = getIntent().getStringExtra("textFromEt4");
            String imageUriString = getIntent().getStringExtra("imageUri");

            textView1.setText(text1);
            textView2.setText(text2);
            textView3.setText(text3);
            textView4.setText(text4);
            Uri imageUri = Uri.parse(imageUriString);
            image.setImageURI(imageUri);
}
    }

}