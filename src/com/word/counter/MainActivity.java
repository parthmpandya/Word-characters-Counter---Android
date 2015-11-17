package com.word.counter;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	EditText etText;
	TextView tvWordWatcher, tvCharWatcher;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		init();
	}

	private void init() {

		etText = (EditText) findViewById(R.id.note);
		etText.setVerticalScrollBarEnabled(true);
		etText.requestFocus();

		tvCharWatcher = (TextView) findViewById(R.id.tvCharWatcher);
		tvWordWatcher = (TextView) findViewById(R.id.tvWordWatcher);
		tvCharWatcher.setText("Characters:0");
		tvWordWatcher.setText("Words:0");

		etText.addTextChangedListener(textWatcher);
	}

	TextWatcher textWatcher = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence s, int start, int before,
				int count) {
			tvCharWatcher.setText("Characters:"
					+ String.valueOf(s.length()));
			tvWordWatcher.setText("Words:" + wordcount(s.toString()));
		}

		@Override
		public void beforeTextChanged(CharSequence s, int start, int count,
				int after) {

		}

		@Override
		public void afterTextChanged(Editable s) {

		}
	};

	public static long wordcount(String line) {
		long numWords = 0;
		int index = 0;
		boolean prevWhiteSpace = true;
		while (index < line.length()) {
			char c = line.charAt(index++);
			boolean currWhiteSpace = Character.isWhitespace(c);
			if (prevWhiteSpace && !currWhiteSpace) {
				numWords++;
			}
			prevWhiteSpace = currWhiteSpace;
		}
		return numWords;
	}
}
