/*
 * Copyright (C) 2016 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);


       final ArrayList<Word> words = new ArrayList<>();


        words.add(new Word("father","әpә",R.drawable.family_father,R.raw.family_father));
        words.add(new Word("mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        words.add(new Word("son","angsi",R.drawable.family_son,R.raw.family_son));
        words.add(new Word("daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        words.add(new Word("older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        words.add(new Word("younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        words.add(new Word("older sister", "teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        words.add(new Word("younger sister","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        words.add(new Word("grandmother", "ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        words.add(new Word("grandfather", "paapa",R.drawable.family_grandfather,R.raw.family_grandfather));

        //Log table used in order to verify the content of the ArrayList words.
//        Log.v("NumberActivity","Word at index 0: " + words.get(0));
//        Log.v("NumberActivity","Word at index 1: " + words.get(1));
//        Log.v("NumberActivity","Word at index 2: " + words.get(2));
//        Log.v("NumberActivity","Word at index 3: " + words.get(3));
//        Log.v("NumberActivity","Word at index 4: " + words.get(4));
//        Log.v("NumberActivity","Word at index 5: " + words.get(5));
//        Log.v("NumberActivity","Word at index 6: " + words.get(6));
//        Log.v("NumberActivity","Word at index 7: " + words.get(7));
//        Log.v("NumberActivity","Word at index 8: " + words.get(8));
//        Log.v("NumberActivity","Word at index 9: " + words.get(9));


        wordAdapter adapter = new wordAdapter(this,words,R.color.category_family);

        ListView listView = (ListView)findViewById(R.id.family_listView);


        assert listView != null;
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = words.get(position);
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudio());
                mediaPlayer.start();

                //releasing the media player when the media has completed the playing media file.
                mediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });


    }


    //Method to release the media file that was playing from the resource. This is used in order to minimise the memory taken by the app.
    public void releaseMediaPlayer() {
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

}
