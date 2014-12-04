package com.example.geoquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	public static final String EXTRA_ANSWER_IS_TRUE ="com.example.geoquiz.answer_is_true";
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
		
		mShowAnswer.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				if (mAnswerIsTrue){
					mAnswerTextView.setText(R.id.true_button);
				}
				else{
					mAnswerTextView.setText(R.id.false_button);
				}
			}
		});
	}

}
