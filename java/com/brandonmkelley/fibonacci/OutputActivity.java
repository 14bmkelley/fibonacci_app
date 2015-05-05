package com.brandonmkelley.fibonacci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class OutputActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		String numberString = intent.getStringExtra(InputActivity.getNumber());
		int number = Integer.parseInt(numberString);

		setContentView(R.layout.activity_output);

	}

}
