package com.st.code;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageActivity extends Activity {
	 EditText editMessage;
  	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_sendmessage);
	        editMessage = (EditText) this.findViewById(R.id.editMessage);
	    }
	    public void sendMessage(View v) {
	    	Intent intent = new Intent("com.st.MESSAGE");
	    	intent.putExtra("message",  editMessage.getText().toString());
	    	this.sendBroadcast(intent);
	    	Log.d("Code", "Message sent");

	    }


}
