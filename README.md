# TextSplitter  [![](https://jitpack.io/v/mehdishz11/SplitText.svg)](https://jitpack.io/#mehdishz11/SplitText)



**Step 1: Add it in your root build.gradle at the end of repositories:**
```xml
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Step 2: Add the dependency**
```xml
dependencies {
	       implementation 'com.github.mehdishz11:SplitText:V1.0.0'
	}
```

**Use as below code to get displayed text in android textView**
Important : have to use in OnGlobalLayoutListener

```java
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
```
