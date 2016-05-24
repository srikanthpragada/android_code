package com.st.code;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AsyncSumActivity extends Activity {

	EditText editNumber;
	TextView textSum, textProgress;
	int sum;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_async_sum);
		editNumber = (EditText) findViewById(R.id.editNumber);
		textSum = (TextView) findViewById(R.id.textSum);
		textProgress = (TextView) findViewById(R.id.textProgress);
	}

	public void calculateSum(View v) {
		 SumTask task = new SumTask();
		 task.execute( editNumber.getText().toString());
	}

    class SumTask extends AsyncTask<String, Integer, Integer> {
        int progress=0;

		// UI Thread
        @Override
        protected void onPreExecute() {
        	textSum.setText("");
        	textProgress.setText( "About to start!");
		}
		// UI Thread
		@Override
		protected void onPostExecute(Integer result) {
            textSum.setText( result.toString());
            textProgress.setText( "");
		}

		// UI Thread
		@Override
		protected void onProgressUpdate(Integer... values) {
			textProgress.setText( "Adding number --> " + values[0]);
		}
		@Override
		protected Integer doInBackground(String ... number) {
			    int num = Integer.parseInt( number[0]);
				sum = 0;
				for (int i = 1; i <= num; i++) {
					try {
						Thread.sleep(1000);
					}
					catch (Exception ex) {
					}
					progress ++;
					sum += i;
					this.publishProgress(progress);
				}
				return   sum;
		}
    }

}
