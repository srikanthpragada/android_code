package com.st.code;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class CallerActivity extends AppCompatActivity {

    EditText editAction, editCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caller);
        editAction = (EditText)  findViewById(R.id.editAction);
        editCategory = (EditText)  findViewById(R.id.editCategory);
    }

    public void callActivity(View v) {
        Intent intent = new Intent();
        intent.setAction(editAction.getText().toString());
        if (! editCategory.getText().toString().equals(""))
              intent.addCategory(editCategory.getText().toString());


        try {
            startActivity(intent);
        }catch(Exception ex) {
            Log.d("Code","Error : "+ ex.getMessage());
        }

    }

    public void callDialor(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_DIAL);  // android.intent.action.DIAL
        Uri uri = Uri.fromParts("tel","12345678","");
        intent.setData(uri);
        startActivity(intent);
    }

    public void showWebsite(View v) {
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        Uri uri = Uri.parse("http://www.srikanthtechnologies.com");
        intent.setData(uri);
        startActivity(intent);
    }
}
