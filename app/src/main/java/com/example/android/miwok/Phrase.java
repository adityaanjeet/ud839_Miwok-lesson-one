package com.example.android.miwok;

public class Phrase {

    private String mMiwokTranslation;
    private String mDefaultTranslation;

    private int mAudio;

    public Phrase(String defaultTranslation, String miwokTranslation, int audio){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudio = audio;

    }

    public String getDefaultTranslation(){


        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {


        return mMiwokTranslation;
    }

    public int getAudio(){
        return mAudio;
    }
}
