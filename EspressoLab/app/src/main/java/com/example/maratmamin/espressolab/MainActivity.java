package com.example.maratmamin.espressolab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView mAccountBalance;
    EditText mEditText;
    Button mAdd;
    Button mRemove;
    Button mInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAccountBalance = (TextView)findViewById(R.id.textview);
        mEditText = (EditText)findViewById(R.id.edittext);
        mAdd = (Button)findViewById(R.id.add);
        mRemove = (Button)findViewById(R.id.remove);
        mInfo = (Button)findViewById(R.id.info);

        mAccountBalance.setText("0");

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountAdd = mAccountBalance.getText().toString();
                String newNumberAdd = mEditText.getText().toString();
                mEditText.getText().clear();
                float accountAddFloat = Float.parseFloat(accountAdd) + Float.parseFloat(newNumberAdd);
                String accountBalance = DecimalFormat.getCurrencyInstance().format(accountAddFloat);
                mAccountBalance.setText(accountBalance);

            }
        });

        mRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String accountRemove = mAccountBalance.getText().toString();
                String accountRemoveParse = accountRemove.substring(1);
                String newNumberRemove = mEditText.getText().toString();
                mEditText.getText().clear();
                float accountRemoveFloat = Float.parseFloat(accountRemoveParse) - Float.parseFloat(newNumberRemove);
                String accountBalance = DecimalFormat.getCurrencyInstance().format(accountRemoveFloat);
                mAccountBalance.setText(accountBalance);
            }
        });

        mInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });
    }
}
