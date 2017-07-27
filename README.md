# ChatBar for Android

A sweet message box designed for Android developers.

![ChatBar for Android](https://i.hizliresim.com/1gGdGj.png)

## Getting Started

### Installing

You can use it step by step

Sample use

``` java
    ChatBarView chatBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatBarView = (ChatBarView) findViewById(R.id.chatbar);
        
        // To set a hint to the text box...
        chatBarView.setMessageBoxHint("Type your message...");
        
        // To set a listener to the "send" button...
        chatBarView.setSendClickListener(...);
        
        // To get the message typed by the user...
        chatBarView.getMessageText();
    }
```

### Set Up

Add dependency to your build.gradle

```
repositories {
        jcenter()
        maven {
            url "http://dl.bintray.com/cnkgn/maven"
        }

    }
    
dependencies {
  compile 'com.cenkgun:chatbar:1.0.3'
}
    
```

## Contributing

Please read [CONTRIBUTING.md](CONTRIBUTING.md) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
