package com.example.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.UUID;

public class AnkGrany extends AppCompatActivity {
    ImageButton arrow, add_photo;
    Button next;
    String id, email, password, status;
    private EditText ed_name, ed_age, ed_inf, ed_problem;
    String help = " ";
    private ImageView imageView;

    FirebaseStorage storage;
    StorageReference storageReference;

    private Uri filePath;

    private final int PICK_IMAGE_REQUEST = 71;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anketa_grany);
        arrow = (ImageButton) findViewById(R.id.arrow);
        next = (Button) findViewById(R.id.SignUp);

        email = getIntent().getExtras().getString("email");
        password = getIntent().getExtras().getString("password");
        status = getIntent().getExtras().getString("status");
        id = getIntent().getExtras().getString("id");

        ed_name = findViewById(R.id.ed_name);
        ed_age = findViewById(R.id.ed_age);
        ed_inf = findViewById(R.id.ed_inf);
        ed_problem = findViewById(R.id.ed_problem);


        View.OnClickListener clickarrow = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i;
                i = new Intent(AnkGrany.this, Reg.class);
                startActivity(i);
            }
        };

        add_photo = findViewById(R.id.add_photo);
        imageView = (ImageView) findViewById(R.id.imgView);
        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();
        add_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chooseImage();
            }
        });

        View.OnClickListener clnext = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(ed_name.getText().toString()) && !TextUtils.isEmpty(ed_age.getText().toString()) && !TextUtils.isEmpty(ed_inf.getText().toString()) && !TextUtils.isEmpty(ed_problem.getText().toString())) {
                    String cod = uploadImage();

                    String nam = ed_name.getText().toString();
                    String age = ed_age.getText().toString();
                    String inf = ed_inf.getText().toString();
                    String problem = ed_problem.getText().toString();
                    Intent i;
                    i = new Intent(AnkGrany.this, CheckNumber.class);
                    i.putExtra("email", email);
                    i.putExtra("password", password);
                    i.putExtra("status", status);
                    i.putExtra("nam", nam);
                    i.putExtra("age", age);
                    i.putExtra("inf", inf);
                    i.putExtra("help", help);
                    i.putExtra("problem", problem);
                    i.putExtra("cod_photo", cod);
                    i.putExtra("id", id);
                    startActivity(i);
                }else{
                    Toast.makeText(getApplicationContext(), "Заполните пустые поля", Toast.LENGTH_SHORT).show();
                }
            }
        };
        arrow.setOnClickListener(clickarrow);
        next.setOnClickListener(clnext);
    }
    private void chooseImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
        Toast.makeText(this, "Фото загружено", Toast.LENGTH_SHORT).show();
    }

    private String uploadImage() {

        if(filePath != null)
        {
            final ProgressDialog progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("Uploading...");
            progressDialog.show();
            String cod = UUID.randomUUID().toString();
            StorageReference ref = storageReference.child("images/"+ cod);
            ref.putFile(filePath)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            progressDialog.dismiss();
                            Toast.makeText(AnkGrany.this, "Uploaded", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(AnkGrany.this, "Failed "+e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            double progress = (100.0*taskSnapshot.getBytesTransferred()/taskSnapshot
                                    .getTotalByteCount());
                            progressDialog.setMessage("Uploaded "+(int)progress+"%");
                        }
                    });
            return cod;
        }else{
            return "no photo";
        }
    }
}

