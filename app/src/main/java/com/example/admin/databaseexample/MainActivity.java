package com.example.admin.databaseexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editTextFind;
    private EditText editTextAdd;
    private EditText add_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextAdd = (EditText) findViewById(R.id.editTextAdd);
        editTextFind = (EditText) findViewById(R.id.editTextFind);
        textView = (TextView) findViewById(R.id.textView);
        add_id = (EditText) findViewById(R.id.add_id);
    }

    public void add_data(View view){
        String Name = editTextAdd.getText().toString();
        MydbHandler db = new MydbHandler(this);
        if(add_id.getText().toString()!= null && Name != null){
            Student student = new Student(Integer.parseInt(add_id.getText().toString()),Name);
            db.addName(student);
        }
        editTextAdd.setText("");
        add_id.setText("");
    }

    public void find_data(View view){
        MydbHandler db = new MydbHandler(this);
        String Name = editTextFind.getText().toString();
        Student student = db.findHandler(Name);
        if(student != null) {
            textView.setText(student.getId()+" "+student.getName());
        }
        else {
            textView.setText("No Match Found !!!");
        }
        editTextFind.setText("");
    }
}
