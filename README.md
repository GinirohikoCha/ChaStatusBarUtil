# ChaStatusBarUtil
An immersive navigation bar &amp; status bar util for Android app.It works for Android 8.0 Oreo(API 26) and above.

[![](https://jitpack.io/v/GinirohikoCha/ChaStatusBarUtil.svg)](https://jitpack.io/#GinirohikoCha/ChaStatusBarUtil)

## Sample
![showcase](https://github.com/GinirohikoCha/ChaStatusBarUtil/blob/master/image/1611902724439.gif)

[download apk](https://github.com/GinirohikoCha/ChaStatusBarUtil/releases/download/1.0.0/demo.apk)
## Usage
#### Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
#### Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.GinirohikoCha:ChaStatusBarUtil:1.0.0'
	}
#### Setp 3. Extends your Activity to ChaStatusBarActivity

Call method **setImmersiveSystemBar(int type)**

	public class MainActivity extends ChaStatusBarActivity {
	
		@Override
		protected void onCreate(@Nullable Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_main);
			
			setImmersiveSystemBar(TRANSPARENT_SYSTEM_BAR);
			// Type Options:
			// TRANSPARENT_STATUS_BAR_AND_TRANSLUCENT_NAVIGATION_BAR
			// TRANSPARENT_SYSTEM_BAR
			// TRANSPARENT_STATUS_BAR_AND_HIDDEN_NAVIGATION_BAR
			setStatusBarLightMode(); // Optional
			setNavigationBarLightMode(); // Optional
		}
	}

Or call util static method:

    public class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            ChaStatusBarUtil.setImmersiveSystemBar(this, ChaStatusBarUtil.TRANSPARENT_SYSTEM_BAR);
            ChaStatusBarUtil.setStatusBarLightMode(this); // Optional
            ChaStatusBarUtil.setNavigationBarLightMode(this); // Optional
        }
    }
#### Setp 4. Get system bar height
You can get system bar height with method **getStatusBarHeight()** or **getNavigationBarHeight()** to adjust your layout(add padding) while in **TRANSPARENT_SYSTEM_BAR** mode
