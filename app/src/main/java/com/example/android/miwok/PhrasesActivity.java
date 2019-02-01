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

public class PhrasesActivity extends AppCompatActivity {

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
        setContentView(R.layout.activity_phrases);


        final ArrayList<Phrase> words = new ArrayList<>();


        words.add(new Phrase("Where are you going?", "minto wuksus", R.raw.phrase_where_are_you_going));
        words.add(new Phrase("What is your name?", "tinn ә oyaase'n ә", R.raw.phrase_what_is_your_name));
        words.add(new Phrase("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
        words.add(new Phrase("How are you feeling?", "mich ә ks ә s?", R.raw.phrase_how_are_you_feeling));
        words.add(new Phrase("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
        words.add(new Phrase("Are you coming?", "әә n ә s'aa?", R.raw.phrase_are_you_coming));
        words.add(new Phrase("Yes, I’m coming.", "h әә ’ әә n ә m", R.raw.phrase_yes_im_coming));
        words.add(new Phrase("I’m coming.", "әә n ә m", R.raw.phrase_im_coming));
        words.add(new Phrase("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
        words.add(new Phrase("Come here.", "ә nni'nem", R.raw.phrase_come_here));

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


        PhraseAdapter adapter = new PhraseAdapter(this, words, R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.phrase_listView);


        assert listView != null;
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Phrase word = words.get(position);
                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getAudio());
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
