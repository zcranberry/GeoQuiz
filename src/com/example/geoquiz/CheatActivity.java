package com.example.geoquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends Activity {
	public static final String EXTRA_ANSWER_IS_TRUE ="com.example.geoquiz.answer_is_true";
	public static final String EXTRA_ANSWER_SHOWN ="com.example.geoquiz.anser_shown";//这两个东西是作为传输时dict的key来用的
	//按以往的想法，传输东西可以用结构体或者一个类来传，用字典的话不知道有什么特殊优势。
	private boolean mAnswerIsTrue;
	private TextView mAnswerTextView;
	private Button mShowAnswer;
	private static boolean mAnswerIsShowed = false;
	
	private void setAnswerShownResult(boolean isAnswerShown){
		Intent data = new Intent();
		data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
		setResult(RESULT_OK, data);//这个RESULT_OK是setResult的保留常量，Geo_activity到底是何时取回的这个值还不知道
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cheat);
		mAnswerTextView = (TextView) findViewById(R.id.answerTextView);
		mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
		mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);//false是默认值
		//mAnswerIsShowed = false;
		setAnswerShownResult(mAnswerIsShowed);//每道题首先设置为未偷看
		
		mShowAnswer.setOnClickListener(new View.OnClickListener() {	
			@Override
			public void onClick(View v) {
				if (mAnswerIsTrue){
					mAnswerTextView.setText(R.string.true_button);
				}
				else{
					mAnswerTextView.setText(R.string.false_button);
				}
				mAnswerIsShowed = true;
				setAnswerShownResult(mAnswerIsShowed);
			}
		});
	}

}
