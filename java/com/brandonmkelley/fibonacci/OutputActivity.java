package com.brandonmkelley.fibonacci;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class OutputActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_output);

		Intent intent = getIntent();
		String numberString = intent.getExtras().getString(InputActivity.NUMBER);

		TextView title = (TextView) findViewById(R.id.outputActivity_title);
		String titleText = "The first " + numberString + " numbers of the Fibonacci Sequence are: ";
		title.setText(titleText);

		int number = Integer.parseInt(numberString);
		String fib = "";

		for (int i = 0; i < number; i++) {

			fib += fibonacci(i + 1);

			if (i != number - 1) {

				fib += ",\n";

			}

		}

		TextView numbers = (TextView) findViewById(R.id.outputActivity_numbers);
		numbers.setText(fib);

	}

	@Override
	public void onBackPressed() {

		Intent intent = new Intent(getBaseContext(), InputActivity.class);
		startActivity(intent);
		finish();

	}

	private BigInteger fibonacci(int n) {

		if (n > 2) {

			BigInteger num1 = new BigInteger("1");
			BigInteger num2 = new BigInteger("2");
			BigInteger tmp;

			for (int i = 3; i < n; i++) {

				tmp = num2;
				num2 = num1.add(num2);
				num1 = tmp;

			}

			return num2;

		} else {

			return new BigInteger("1");

		}

	}

}
