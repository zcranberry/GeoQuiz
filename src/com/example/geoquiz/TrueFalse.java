package com.example.geoquiz;

public class TrueFalse {
    private int mQuestion;
    // this variable will hold a resource ID for a string

    private boolean mTrueQuestion;
    
    public TrueFalse(int question, boolean trueQuestion) {//这里的风格是用一个int（resource ID）来索引一个问题，
    	//而非直接存文本，是一种代码和内容分离的好习惯
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }

	public int getQuestion() {
		return mQuestion;
	}

	public void setQuestion(int question) {
		mQuestion = question;
	}

	public boolean isTrueQuestion() {//这里的命名风格略奇怪
		return mTrueQuestion;
	}

	public void setTrueQuestion(boolean trueQuestion) {
		mTrueQuestion = trueQuestion;
	}

}
