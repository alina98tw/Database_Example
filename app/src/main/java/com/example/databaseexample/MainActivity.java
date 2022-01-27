package com.example.databaseexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }

    // Code for the LOAD DATA button
    public void loadStudents(View view) {
        TextView lst = findViewById(R.id.lst);
        EditText studentid = findViewById(R.id.studentid);
        EditText studentname = findViewById(R.id.studentname);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        lst.setText(dbHandler.loadHandler());
        studentid.setText("");
        studentname.setText("");
    }

    // Code for the ADD button
    public void addStudent(View view) {
        EditText studentid = findViewById(R.id.studentid);
        EditText studentname = findViewById(R.id.studentname);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        int id = Integer.parseInt(studentid.getText().toString());
        String name = studentname.getText().toString();
        Student student = new Student(id, name);
        dbHandler.addHandler(student);
        studentid.setText("");
        studentname.setText("");
    }

    // Code for the FIND button
    public void findStudent(View view) {
        TextView lst = findViewById(R.id.lst);
        EditText studentid = findViewById(R.id.studentid);
        EditText studentname = findViewById(R.id.studentname);
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);
        Student student =
                dbHandler.findHandler(studentname.getText().toString());
        if (student != null) {
            lst.setText(student.getID() + " " + student.getStudentName() + System.getProperty("line.separator"));
            studentid.setText("");
            studentname.setText("");
        } else {
            lst.setText("No Match Found");
            studentid.setText("");
            studentname.setText("");
        }
    }

    // Code for the DELETE button
    public void removeStudent(View view) {
        TextView lst = findViewById(R.id.lst);
        EditText studentid = findViewById(R.id.studentid);
        EditText studentname = findViewById(R.id.studentname);
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.deleteHandler(Integer.parseInt(
                studentid.getText().toString()));
        if (result) {
            studentid.setText("");
            studentname.setText("");
            lst.setText("Record Deleted");
        } else
            studentid.setText("No Match Found");
    }

    // Code for the UPDATE button
    public void updateStudent(View view) {
        TextView lst = findViewById(R.id.lst);
        EditText studentid = findViewById(R.id.studentid);
        EditText studentname = findViewById(R.id.studentname);
        MyDBHandler dbHandler = new MyDBHandler(this, null,
                null, 1);
        boolean result = dbHandler.updateHandler(Integer.parseInt(
                studentid.getText().toString()), studentname.getText().toString());
        if (result) {
            studentid.setText("");
            studentname.setText("");
            lst.setText("Record Updated");
        } else
            studentid.setText("No Match Found");
    }

}