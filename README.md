# 参考
https://github.com/shamanland/floating-action-button

#截图
![image](https://raw.githubusercontent.com/Blankeer/ScrollHideView/master/image.gif)


# 使用
```
Step 1. Add the JitPack repository to your build file
Add it in your root build.gradle at the end of repositories:
	allprojects {
		repositories {
			...
			maven { url "https://jitpack.io" }
		}
	}
Step 2. Add the dependency
	dependencies {
	        compile 'com.github.Blankeer:ScrollHideView:V0.1'
	}
```

```
<com.blanke.lib.scrollholdview.ScrollHideView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_margin="5dp"
        android:id="@+id/hideView"
        app:animIn="@anim/in"
        app:animOut="@anim/out"
        app:targetView="@id/recyclerview">
        <TextView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:background="@color/colorPrimary"
            android:gravity="center"
            android:padding="30dp"
            android:text="this is a test TextView!"
            android:textColor="#fff"
            android:textSize="20sp" />
    </com.blanke.lib.scrollholdview.ScrollHideView>
```
animIn:进入动画

animOut:离开动画

targetView:目标View，也就是观察源，监听这个控件的滑动状态，可任意View



