# SpecialDialogs

https://im.ezgif.com/tmp/ezgif-1-f89aac31ac0d.gif

How to
To get a Git project into your build:

Step 1. Add the JitPack repository to your build file

gradle
maven
sbt
leiningen
Add it in your root build.gradle at the end of repositories:

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
Step 2. Add the dependency

	dependencies {
	        implementation 'com.github.Abdulaziz-android:SpecialDialogs:Tag'
	}
Share this release
