package com.am.mdrr.mdsimple;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import com.am.mdrr.R;

public class TextInputActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText mEtAccount;
    private TextInputLayout mTextInput;

    /**
     * TextInputLayout  有用于做错误检验的api
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textinput);
        other();

        mEtAccount= (EditText) findViewById(R.id.mEtAccount);
        mTextInput = (TextInputLayout) findViewById(R.id.mTextInput);

        mEtAccount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()>4) {
                    mTextInput.setErrorEnabled(true);
                    mTextInput.setError("超过5位字符");
                    return;
                } else {
                    mTextInput.setErrorEnabled(false);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    private void other() {
        toolbar = (Toolbar) findViewById(R.id.mToolbar);
        toolbar.setTitle("TextInput");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        toolbar.findViewById(R.id.mTvTip).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(TextInputActivity.this);
                // 设置标题
                builder.setTitle("提示：");
                // 设置描述信息
                builder.setMessage("TextInputLayout是一个能够把EditText包裹在当中的一个布局，当输入文字时，它可以把Hint文字飘到EditText的上方。");
                builder.show();
            }
        });
    }
}
