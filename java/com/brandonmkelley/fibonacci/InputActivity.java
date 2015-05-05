package com.brandonmkelley.fibonacci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

public class InputActivity extends Activity {

	private static final String NUMBER = "com.brandonmkelley.fibonacci.NUMBER";

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_input);

		//key listener for input edittext, transitions to OutputActivity
		final EditText input = (EditText) findViewById(R.id.inputActivity_input);
		input.setOnKeyListener(new OnKeyListener() {

			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {

				if (keyCode == KeyEvent.KEYCODE_ENTER) {

					Intent intent = new Intent(getBaseContext(), OutputActivity.class);

					//store number of fibonacci numbers requested
					String number = input.getText().toString();
					intent.putExtra(NUMBER, number);

					startActivity(intent);
					return true;

				}

				return false;

			}

		});

	}

	public static String getNumber() {

		return NUMBER;

	}

}
