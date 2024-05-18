package com.example.tugaspraktikum2;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public class MainActivity2 extends AppCompatActivity {

        private EditText et1;
        private EditText et2;
        private ImageView image;
        private Button btn;

        private String textFromEt1;
        private String textFromEt2;
        private Uri imageUri;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_main);

            et1 = findViewById(R.id.nama);
            et2 = findViewById(R.id.username);
            image = findViewById(R.id.getPict);
            btn = findViewById(R.id.btnSubmit);

            image.setOnClickListener(view -> {
                Intent open = new Intent(Intent.ACTION_PICK);
                open.setType("image/*");
                launcherIntentGallery.launch(open);
            });

            btn.setOnClickListener(view -> {
                textFromEt1 = et1.getText().toString().trim();
                textFromEt2 = et2.getText().toString().trim();

                if (textFromEt1.isEmpty() || textFromEt2.isEmpty()) {
                    Toast.makeText(this, "Isi semua field terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else if (imageUri == null) {
                    Toast.makeText(this, "Pilih gambar terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(this, MainActivity2.class);
                    intent.putExtra("textFromEt1", textFromEt1);
                    intent.putExtra("textFromEt2", textFromEt2);
                    intent.putExtra("imageUri", imageUri.toString());
                    startActivity(intent);
                }
            });
        }

        ActivityResultLauncher<Intent> launcherIntentGallery = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        if (data != null) {
                            imageUri = data.getData();
                            image.setImageURI(imageUri);
                        }
                    }
                });

        public String getTextFromEt1() {
            return textFromEt1;
        }

        public String getTextFromEt2() {
            return textFromEt2;
        }

        public Uri getImageUri() {
            return imageUri;
        }
    }

}