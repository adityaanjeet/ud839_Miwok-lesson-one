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
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


        final ArrayList<Word> words = new ArrayList<>();


        words.add(new Word("one", "lutti", R.drawable.number_one, R.raw.number_one));
        words.add(new Word("two", "otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("three", "tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("four", "oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("five", "massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("six", "temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("seven", "kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("eight", "kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("nine", "wo’e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("ten", "na’aacha", R.drawable.number_ten, R.raw.number_ten));

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


        wordAdapter adapter = new wordAdapter(this, words, R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.number_listView);


        assert listView != null;
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Word word = words.get(position);


                //relesing previous medi that was playing and in the middle a new media has been asked to play.
                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudio());

                //start the mediaPlayer
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
