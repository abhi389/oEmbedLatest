package com.oembed.itslearning.oembedproject;


import android.content.Context;

import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class oEmbedCustomView extends RelativeLayout {
    View rootView;
    EditText editTextView;
    View submitButton;

    public oEmbedCustomView(Context context) {
        super(context);
        init(context);
    }
    public oEmbedCustomView(Context context,AttributeSet attrs) {
        super(context,attrs);
        init(context);
    }

    private void init(final Context context) {
        rootView = inflate(context, R.layout.oembed_custom, this);
        editTextView = (EditText) rootView.findViewById(R.id.editText);

        submitButton = rootView.findViewById(R.id.button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str[]=editTextView.getText().toString().split("\n");
                new RetrieveFeedTask((RelativeLayout) findViewById(R.id.oEmbedCustomView),context)
                        .execute(str);

            }
        });


    }

}

