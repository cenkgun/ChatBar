package com.cenkgun.chatbar;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/**
 * Created by Cenk Gun on 10.07.2017.
 */

public class ChatBarView extends FrameLayout {

    private EditText messageEditText;
    private ImageButton sendButton;

    private CharSequence[] mTint;
    private int mColor;


    public ChatBarView(Context context) {
        super(context);
        initializeViews(context);
    }

    public ChatBarView(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray;
        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.chatbar);
        mTint = typedArray
                .getTextArray(R.styleable.chatbar_messageBoxTint);

        mColor = typedArray
                .getColor(R.styleable.chatbar_messageBoxTint, 0);

        typedArray.recycle();

        initializeViews(context);
    }

    public ChatBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray;
        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.chatbar);
        mTint = typedArray
                .getTextArray(R.styleable.chatbar_messageBoxTint);

        mColor = typedArray
                .getColor(R.styleable.chatbar_messageBoxTint, 0);

        typedArray.recycle();

        initializeViews(context);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ChatBarView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initializeViews(context);
    }

    private void initializeViews(Context context) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chatbar_layout, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

        messageEditText = (EditText) this.findViewById(R.id.messageEditText);
        sendButton = (ImageButton) this.findViewById(R.id.sendButton);
    }

    public void setSendClickListener(OnClickListener listener) {
        sendButton.setOnClickListener(listener);
    }

    public void setMessageBoxHint(String text) {
        messageEditText.setHint(text);
    }

    public String getMessageText() {
        if (messageEditText.getText() != null) {
            return messageEditText.getText().toString();
        } else {
            return "";
        }
    }
}
