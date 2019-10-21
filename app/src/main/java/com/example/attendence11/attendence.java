package com.example.attendence11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class attendence extends AppCompatActivity {
EditText sub_name;
Button save,add;
    DatabaseReference reff1;
    subject subject;
    student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendence);
        sub_name=(EditText)findViewById(R.id.sub_name);
        save=(Button)findViewById(R.id.save);
        add=(Button)findViewById(R.id.add);
        subject=new subject();
        student=new student();
        reff1= FirebaseDatabase.getInstance().getReference().child("Subject");
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject.setSub_name(sub_name.getText().toString().trim());

                reff1.push().setValue(subject);

                open_mainpage();
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subject.setSub_name(sub_name.getText().toString().trim());
                reff1.push().setValue(subject);
                open_attendence();
            }
        });

    }
    public void open_mainpage(){
        Intent intent=new Intent(this,mainpage.class);
        startActivity(intent);
    }
    public void open_attendence(){
        Intent intent=new Intent(this,attendence.class);
        startActivity(intent);
    }
}
