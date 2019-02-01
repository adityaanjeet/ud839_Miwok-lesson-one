package com.example.android.miwok;

public class Word {
    private String mMiwokTranslation;
    private String mDefaultTranslation;
    private int mImage;
    private int mAudio;


    public Word(String defaultTranslation, String miwokTranslation, int image, int audio){

        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImage = image;
        mAudio = audio;

    }

    public String getDefaultTranslation(){


        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {


        return mMiwokTranslation;
    }

    public int getImage(){


        return mImage;
    }

    public int getAudio(){
        return mAudio;
    }
}
