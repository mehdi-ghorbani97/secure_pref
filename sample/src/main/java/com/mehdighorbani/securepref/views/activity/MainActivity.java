package com.mehdighorbani.securepref.views.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;
import com.mehdighorbani.scurepref.SecurePref;
import com.mehdighorbani.securepref.R;
import com.mehdighorbani.securepref.model.User;


public class MainActivity extends AppCompatActivity {


    //EditText
    private TextInputEditText mEditTextString;
    private TextInputEditText mEditTextInt;
    private TextInputEditText mEditTextLong;
    private TextInputEditText mEditTextDouble;
    private TextInputEditText mEditTextPojoName;
    private TextInputEditText mEditTextPojoFamily;

    //Button
    private Button mButtonString;
    private Button mButtonInt;
    private Button mButtonLong;
    private Button mButtonDouble;
    private Button mButtonPojo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        putViewsValue();
        setOnClickListener();


    }


    private void bindViews() {

        //Bind EditText
        mEditTextString = findViewById(R.id.string);
        mEditTextInt = findViewById(R.id.integer);
        mEditTextLong = findViewById(R.id.long_);
        mEditTextDouble = findViewById(R.id.double_);
        mEditTextPojoName = findViewById(R.id.pojo_name);
        mEditTextPojoFamily = findViewById(R.id.pojo_family);

        //Bind Button
        mButtonString = findViewById(R.id.btn_string);
        mButtonInt = findViewById(R.id.btn_int);
        mButtonLong = findViewById(R.id.btn_long);
        mButtonDouble = findViewById(R.id.btn_double);
        mButtonPojo = findViewById(R.id.btn_pojo);


    }

    private void putViewsValue() {

        try {
            mEditTextString.setText(SecurePref.getString("string", null));
            mEditTextInt.setText(String.valueOf(SecurePref.getInt("int")));
            mEditTextLong.setText(String.valueOf(SecurePref.getLong("long")));
            mEditTextDouble.setText(String.valueOf(SecurePref.getDouble("double")));
            User user = SecurePref.get("pojo", User.class);
            mEditTextPojoName.setText(user.getName());
            mEditTextPojoFamily.setText(user.getFamily());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setOnClickListener() {

        mButtonString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SecurePref.putString("string", mEditTextString.getText().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

        mButtonInt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SecurePref.putInt("int", Integer.valueOf(mEditTextInt.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mButtonLong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SecurePref.putLong("long", Integer.valueOf(mEditTextLong.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mButtonDouble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SecurePref.putDouble("double", Double.valueOf(mEditTextDouble.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        mButtonPojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    SecurePref.put("pojo", new User(mEditTextPojoName.getText().toString(), mEditTextPojoFamily.getText().toString()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
