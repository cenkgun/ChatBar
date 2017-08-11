package com.cenkgun.chatbar;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

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
    private String micClickWarningMessage = "Long press...";

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
                .getColor(R.styleable.chatbar_cb_sendButtonColor, Color.rgb(00, 96, 88));

        sendButtonBackgroundColor = typedArray
                .getColor(R.styleable.chatbar_cb_sendButtonBackgroundColor, Color.WHITE);

        micClickWarningMessage = typedArray
                .getString(R.styleable.chatbar_cb_micClickWarningMessage);

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
        sendButton.setImageResource(R.drawable.ic_mic);
        sendButton.setColorFilter(sendButtonBackgroundColor);
        sendButton.getBackground().setColorFilter(sendButtonColor, PorterDuff.Mode.SRC_ATOP);
        if (messageBoxHint != null) messageEditText.setHint(messageBoxHint);
        messageEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (i2 != 0) {
                    sendButton.setImageResource(R.mipmap.input_send);
                } else {
                    sendButton.setImageResource(R.drawable.ic_mic);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }

    public void setOnMicListener(final OnLongClickListener listener) {
        sendButton.setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                if (messageEditText.getText().length() == 0) {
                    listener.onLongClick(view);
                }
                return true;
            }
        });
    }

    public void setSendClickListener(final OnClickListener listener) {
        sendButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                if (messageEditText.getText().length() == 0) {
                    Toast.makeText(context, micClickWarningMessage, Toast.LENGTH_SHORT).show();
                }

                if (isAutoClearEnabled) {
                    messageEditText.setText("");
                }

                if (isSoftInputHidden) {
                    hideSoftInput();
                }

                listener.onClick(view);

            }
        });
    }

    public void setMicErrorMessage(String message) {
        micClickWarningMessage = message;
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
