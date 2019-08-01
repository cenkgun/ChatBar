# ChatBar for Android

A sweet message box designed for Android developers.

![ChatBar for Android](https://i.hizliresim.com/5Q6y8L.gif)

## Getting Started


----------


### Installing

You can use it step by step

**Sample use**

``` java
chatBarView = (ChatBarView) findViewById(R.id.chatbar);
chatBarView.setSendClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        //TODO what you want..
    }
});
chatBarView.setOnMicListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {
        //TODO what you want..
        return true;
    }
});
text = chatBarView.getMessageText();
```
**Layout**


    
    <com.cenkgun.chatbar.ChatBarView
        android:id="@+id/chatbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_alignParentLeft="true"
        android:layout_alignParentStart="true"
        app:cb_isTextCleanerEnabled="true"
        app:cb_isSoftInputHidden="true"
        app:cb_messageBoxHint="sample text"
        app:cb_micClickWarningMessage="warning message">
        


----------


**Attributes**

|        Attribute Name        | Type    | Default Value |
|:----------------------------:|---------|---------------|
| cb_isTextCleanerEnabled      | boolean | true          |
| cb_isSoftInputHidden         | boolean | false         |
| cb_messageBoxHint            | String  |               |
| cb_micClickWarningMessage    | String  | Long press... |
| cb_sendButtonColor           | Color   | Color.WHITE   |
| cb_sendButtonBackgroundColor | Color   | Color.BLUE    |


----------


### Dependency
Add it in your root build.gradle at the end of repositories:
```
    allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
     }
```
     
Add the dependency

    dependencies {
    	    compile 'com.github.CenkGun:ChatBar:1.0.5'
    	}
## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
