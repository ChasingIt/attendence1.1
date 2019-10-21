package com.example.attendence11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class mainpage extends AppCompatActivity  {
TextView name,col_name,sub1,sub2,branch;
    subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainpage);
        name=(TextView)findViewById(R.id.name);
        col_name=(TextView)findViewById(R.id.col_name);
        sub1=(TextView)findViewById(R.id.sub1);
        sub2 =(TextView)findViewById(R.id.sub2);
        branch=(TextView)findViewById(R.id.branch);
        subject=new subject();

        name.setText(subject.getName());
        col_name.setText(subject.getCol_name());
        branch.setText(subject.getBranch());
    }
}
