# ChaStatusBarUtil
An immersive navigation bar &amp; status bar util for Android app.It works for Android 8.0 Oreo(API 26) and above.

[![](https://jitpack.io/v/GinirohikoCha/ChaStatusBarUtil.svg)](https://jitpack.io/#GinirohikoCha/ChaStatusBarUtil)

## Sample
![showcase](https://github.com/GinirohikoCha/ChaStatusBarUtil/blob/master/image/1611902724439.gif)

[download apk](https://github-releases.githubusercontent.com/334059680/ec359000-6249-11eb-8f67-40569240a58d?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20210129%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20210129T075226Z&X-Amz-Expires=300&X-Amz-Signature=caf3da3058ea31194a4841c5fa3106bfc38ed7cf8691cf3753a05c96169798f4&X-Amz-SignedHeaders=host&actor_id=26181775&key_id=0&repo_id=334059680&response-content-disposition=attachment%3B%20filename%3Ddemo.apk&response-content-type=application%2Fvnd.android.package-archive)
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

call method **setImmersiveSystemBar(int type)**

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

or call the util method:
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ChaStatusBarUtil.setImmersiveSystemBar(this, ChaStatusBarUtil.TRANSPARENT_SYSTEM_BAR);
		ChaStatusBarUtil.setStatusBarLightMode(this); // Optional
		ChaStatusBarUtil.setNavigationBarLightMode(this); // Optional
	}
#### Setp 4. Get system bar height
You can get system bar height with method **getStatusBarHeight()** or **getNavigationBarHeight()** to adjust your layout(add padding) while in **TRANSPARENT_SYSTEM_BAR** mode
