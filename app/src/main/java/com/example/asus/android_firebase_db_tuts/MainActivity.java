package com.example.asus.android_firebase_db_tuts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    DatabaseReference databaseReference;
    Button btnClickMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * database ref
         */
        databaseReference = FirebaseDatabase.getInstance().getReference("students");



        btnClickMe = findViewById(R.id.button_click);

        btnClickMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                clickMe();
            }
        });




    }

    private void clickMe() {

        String id = databaseReference.push().getKey();

        String name = "ford";
        String address = "milagrosa";

        Student student = new Student(id,name,address);

        databaseReference.child(id).setValue(student);
        Toast.makeText(this, name + " added.", Toast.LENGTH_SHORT).show();

    }
}
