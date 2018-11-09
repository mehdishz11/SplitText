package com.rasa.textviewsplit;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;


public class SplitTextView extends AppCompatTextView {

    public SplitTextView(Context context) {
        super(context);
    }

    public SplitTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SplitTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public String getDisplayText( ) {
        int height = getHeight();
        int scrollY = getScrollY();
        Layout layout = getLayout();

        int firstVisibleLineNumber = layout.getLineForVertical(scrollY);
        int lastVisibleLineNumber = layout.getLineForVertical(scrollY + height);

        int start = getLayout().getLineStart(firstVisibleLineNumber);
        int end = getLayout().getLineEnd(lastVisibleLineNumber - 1);
        String displayed = getText().toString().substring(start, end);


            setMaxLines(lastVisibleLineNumber);
            setEllipsize(TextUtils.TruncateAt.END);


        return displayed;
    }

}
