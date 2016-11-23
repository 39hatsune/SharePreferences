package com.zhiyuan3g.sharedpreferencesdemo;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtIn;
    private Button btnWrite;
    private Button btnRead;
    private TextView txtOut;
    SharedPreferences sp;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        sp = getSharedPreferences("userInfo",MODE_PRIVATE);
        editor = sp.edit();
    }

    private void initView() {
        txtIn = (EditText) findViewById(R.id.txtIn);
        btnWrite = (Button) findViewById(R.id.btnWrite);
        btnRead = (Button) findViewById(R.id.btnRead);
        txtOut = (TextView) findViewById(R.id.txtOut);

        btnWrite.setOnClickListener(this);
        btnRead.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnWrite:
                String userInfo = txtIn.getText().toString();
                editor.putString("userInfo",userInfo);
                editor.commit();
                break;
            case R.id.btnRead:
                //null是值不存在时的默认值
                txtOut.setText(sp.getString("userInfo",null));
                break;
        }
    }
}
