# SpecialDialogs

![mydialoggif](https://user-images.githubusercontent.com/66155702/143823240-0f0ef623-3e5b-49e0-bbaf-8325a1b0e15a.gif)

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
	        implementation 'com.github.Abdulaziz-android:SpecialDialogs:1.0'
	}
Share this release
