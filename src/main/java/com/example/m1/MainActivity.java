package com.example.m1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEdit;
    private Button mSearch;
    private FlowLayout mFlowLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEdit = findViewById(R.id.edit_keys);
        mSearch = findViewById(R.id.btn_search);
        mFlowLayout = findViewById(R.id.flow_layout);
        mSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.btn_search){
            String keys = mEdit.getText().toString();
            mFlowLayout.addTextView(keys);
        }else{
            mFlowLayout.removeAllViews();
        }
    }
}
