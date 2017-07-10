# ChatBar for Android

A sweet message box designed for Android developers.

![ChatBar for Android](https://i.hizliresim.com/1gGdGj.png)

## Getting Started

### Installing

You can use it step by step

Sample use

```
    ChatBarView chatBarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chatBarView = (ChatBarView) findViewById(R.id.chatbar);
    }
```

### Set Up

Add dependency to your build.gradle

```
	dependencies {
    	compile 'com.cenkgun:chatbar:1.0.2'
	}
    
```

## Contributing

Please read [CONTRIBUTING.md](https://gist.github.com/PurpleBooth/b24679402957c63ec426) for details on our code of conduct, and the process for submitting pull requests to us.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details
