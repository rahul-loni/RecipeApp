package com.example.recipe_app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.DateFormat;
import java.util.Calendar;

public class Upload_recipe extends AppCompatActivity {
    ImageView imageView;
    EditText edit_name,edit_dis,edit_price;
    Uri uri;
    String ImageUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_recipe);

        imageView=findViewById(R.id.food_image);
        edit_name=findViewById(R.id.txt_name);
        edit_dis=findViewById(R.id.txt_dis);
        edit_price=findViewById(R.id.txt_price);

    }

    public void SelectImage(View view) {
        Intent photopicker=new Intent(Intent.ACTION_PICK);
        photopicker.setType("image/*");
        startActivityForResult(photopicker,1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode==RESULT_OK){
         uri=data.getData();
         imageView.setImageURI(uri);
        }else {
            Toast.makeText(this, "not Select", Toast.LENGTH_SHORT).show();
        }

    }
    public void uploadImage(){
        StorageReference storageReference= FirebaseStorage.getInstance().getReference()
                .child("RecipeImage").child(uri.getLastPathSegment());
        storageReference.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri>uriTask=taskSnapshot.getStorage().getDownloadUrl();
                while (!uriTask.isComplete());
                Uri urlImage=uriTask.getResult();
                ImageUrl=urlImage.toString();
                uploadRecipe();
                Toast.makeText(Upload_recipe.this, "Image Uploaded", Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void uploadImage(View view) {
        uploadRecipe();
    }

    private void uploadRecipe() {
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Recipe Uploading.....");
        progressDialog.show();
        FoodData foodData=new FoodData(
                 edit_name.getText().toString(),edit_dis.getText().toString(),edit_price.getText().toString(),
                ImageUrl
        );
        String myCurrentDatatime= DateFormat.getDateInstance().format(Calendar.getInstance().getTime());
   FirebaseDatabase.getInstance().getReference("Recipe").child(myCurrentDatatime).setValue(foodData)
           .addOnCompleteListener(new OnCompleteListener<Void>() {
               @Override
               public void onComplete(@NonNull Task<Void> task) {
               if (task.isSuccessful()){
                   Toast.makeText(Upload_recipe.this, "Recipe Uploaded", Toast.LENGTH_SHORT).show();
                   progressDialog.dismiss();
                   finish();
               }
               }
           }).addOnFailureListener(new OnFailureListener() {
       @Override
       public void onFailure(@NonNull Exception e) {
           Toast.makeText(Upload_recipe.this,e.getMessage().toString(),  Toast.LENGTH_SHORT).show();
           progressDialog.dismiss();
       }
   });
    }
}