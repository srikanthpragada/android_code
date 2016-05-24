
// this program should display ANR dialog after 5 seconds

package com.st.code;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class UISumActivity extends Activity {

	EditText editNumber;
	TextView textSum;
	int sum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_activity_sum);
		editNumber = (EditText) findViewById(R.id.editNumber);
		textSum = (TextView) findViewById(R.id.textSum);
	}

	public void reset(View v) {
		 editNumber.setText("");
		 textSum.setText("");
	}
	public void calculateSum(View v) {
		int num = Integer.parseInt(editNumber.getText().toString());
		sum = 0;
		for (int i = 1; i <= num; i++) {
			try {
				Thread.sleep(1000);
			}
			catch (Exception ex) {
			}
			sum += i;
		}
		// textSum.setText(String.valueOf(sum));
		textSum.setText( "Sum = " + sum);
	}
	


}
