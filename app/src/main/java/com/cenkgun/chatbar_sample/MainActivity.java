package com.cenkgun.chatbar_sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.cenkgun.chatbar.ChatBarView;

public class MainActivity extends AppCompatActivity {

    ChatBarView chatBarView;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatBarView = (ChatBarView) findViewById(R.id.chatbar);

        chatBarView.setSendClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO what you want..
                Toast.makeText(MainActivity.this, chatBarView.getMessageText(), Toast.LENGTH_SHORT).show();
            }
        });

        text = chatBarView.getMessageText();
    }


}
