package com.rasa.textSplitter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewTreeObserver;

import com.rasa.textviewsplit.SplitTextView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG="textSplit";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SplitTextView splitTextView=findViewById(R.id.text_sample);
        splitTextView.setText(R.string.sample_text);


        splitTextView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //دریافت مقدار رشته ای که در حال نمایش است
                Log.d(TAG, "onCreate: "+splitTextView.getDisplayText());
                //بدست آرودن طول رشته در حال نمایش
                Log.d(TAG, "onCreate: "+splitTextView.getDisplayText().length());
                //بدست آوردن ادامه رشته

                String nextPartString=splitTextView.getText().toString().substring(splitTextView.getDisplayText().length());

                splitTextView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }
        });



    }
}
