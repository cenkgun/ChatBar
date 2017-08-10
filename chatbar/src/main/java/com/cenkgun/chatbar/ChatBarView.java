package com.cenkgun.chatbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;

/**
 * Created by Cenk Gun on 10.07.2017.
 */

public class ChatBarView extends FrameLayout {

    private EditText messageEditText;
    private ImageButton sendButton;
    private Context context;
    private boolean isAutoClearEnabled;
    private boolean isSoftInputHidden;
    private String messageBoxHint = null;
    private int sendButtonColor;
    private int sendButtonBackgroundColor;

    public ChatBarView(Context context) {
        this(context, null);
    }

    public ChatBarView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ChatBarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initializeViews(context, attrs);
    }

    private void initializeViews(Context context, AttributeSet attrs) {

        TypedArray typedArray;
        typedArray = context
                .obtainStyledAttributes(attrs, R.styleable.chatbar);

        messageBoxHint = typedArray
                .getString(R.styleable.chatbar_cb_messageBoxHint);

        isAutoClearEnabled = typedArray
                .getBoolean(R.styleable.chatbar_cb_isTextCleanerEnabled, true);

        isSoftInputHidden = typedArray
                .getBoolean(R.styleable.chatbar_cb_isSoftInputHidden, false);

        sendButtonColor = typedArray
                .getColor(R.styleable.chatbar_cb_sendButtonColor, Color.WHITE);

        sendButtonBackgroundColor = typedArray
                .getColor(R.styleable.chatbar_cb_sendButtonBackgroundColor, Color.BLUE);

        typedArray.recycle();

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chatbar_layout, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        messageEditText = this.findViewById(R.id.messageEditText);
        sendButton = this.findViewById(R.id.sendButton);
        sendButton.setColorFilter(sendButtonBackgroundColor);
        sendButton.getBackground().setColorFilter(sendButtonColor, PorterDuff.Mode.SRC_ATOP);
        if (messageBoxHint != null) messageEditText.setHint(messageBoxHint);
    }

    public void setSendClickListener(final OnClickListener listener) {
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(view);

                if (isAutoClearEnabled) {
                    messageEditText.setText("");
                }

                if (isSoftInputHidden) {
                    hideSoftInput();
                }
            }
        });
    }

    public String getMessageText() {
        if (messageEditText.getText() != null) {
            return messageEditText.getText().toString();
        } else {
            return "";
        }
    }

    public void hideSoftInput() {
        View view = ((Activity) context).getCurrentFocus();
        if (view == null) view = new View(((Activity) context));
        InputMethodManager imm = (InputMethodManager) ((Activity) context).getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm == null) return;
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
