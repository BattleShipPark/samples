package com.battleshippark.mylibrary;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubActivity extends Activity {
    @BindView(R2.id.text)
    TextView textView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);
        ButterKnife.bind(this);

        textView.setText(textView.getText() + "-" + getResources().getString(R.string.app_name2));
    }
}
