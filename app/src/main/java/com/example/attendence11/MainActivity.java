package com.example.attendence11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
EditText name,col_name,branch,id;
Button b1;
DatabaseReference reff;
student student;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.name);
        col_name=(EditText)findViewById(R.id.col_name);
        branch=(EditText)findViewById(R.id.branch);
        id=(EditText)findViewById(R.id.id);
        b1=(Button) findViewById(R.id.save);
        student=new student();
        reff= FirebaseDatabase.getInstance().getReference().child("Student");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 int i_d=Integer.parseInt(id.getText().toString().trim());
                  student.setName(name.getText().toString().trim());
                student.setCol_name(col_name.getText().toString().trim());
                student.setBranch(branch.getText().toString().trim());

                reff.push().setValue(student);
                open_attendence();
            }
        });
    }
    public void open_attendence(){
        Intent intent = new Intent(this,attendence.class);
        startActivity(intent);
    }
}