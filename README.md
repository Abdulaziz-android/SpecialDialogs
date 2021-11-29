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


## Basic Dialog
```
val basicDialog = BasicDialog()
basicDialog.build("title text", "message text", "negative text", "positive text")
basicDialog.setOnButtonClickListener(object : BasicDialog.DialogButtonsClickListener{
            override fun NegativeButtonClicked() {
                Toast.makeText(this@MainActivity, "Negative button clicked", Toast.LENGTH_SHORT).show()
            }

            override fun PositiveButtonClicked() {
                Toast.makeText(this@MainActivity, "Positive button clicked", Toast.LENGTH_SHORT).show()
            }

        })
basicDialog.show(supportFragmentManager, "dialog")
```

## CheckBox Dialog
```
val list = arrayListOf<String>("item1", "item2", "item3")
  
val checkBoxDialog = CheckBoxDialog(list, "title text")
        checkBoxDialog.setOnChooseClickListener(object : CheckBoxDialog.OnChooseClickListener{
            override fun chooseClick(chosenList: List<String>) {
                val stringBuilder = StringBuilder()
                chosenList.forEach {
                    stringBuilder.append(it+" ")
                }
                Toast.makeText(this@MainActivity, stringBuilder.toString(), Toast.LENGTH_SHORT).show()
            }

        })
checkBoxDialog.show(supportFragmentManager, "checkbox_dialog")
```

## Date Dialog
```
val dateDialog = DateDialog()
dateDialog.setOnOkButtonClicked(object : DateDialog.OnButtonClicked{
            @RequiresApi(Build.VERSION_CODES.M)
            override fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker) {
                val date = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}  " +
                        "${timePicker.hour}:${timePicker.minute}"
                Toast.makeText(this@MainActivity, date, Toast.LENGTH_SHORT).show()
            }


        })
dateDialog.show(supportFragmentManager, "date dialog")
```

## Basic BottomsheetDialog
```
val basicBottomSheetDialog = BasicBottomSheetDialog()
basicBottomSheetDialog.build("wifi name text", "signal text", "ssid text", "security text")
basicBottomSheetDialog.setOnConnectClickListener(object :BasicBottomSheetDialog.SetOnConnectClickListener{
            override fun OnConnectClicked(password: String) {
                Toast.makeText(this@MainActivity, "password $password", Toast.LENGTH_SHORT).show()
            }

        })
basicBottomSheetDialog.show(supportFragmentManager, "bottomsheet dialog")
```

## Color BottomSheetDialog
```
val bottomSheetDialog = ColorBottomSheetDialog()
        bottomSheetDialog.setOnColorSelectedListener(object :ColorBottomSheetDialog.OnColorSelectListener{
            override fun OnColorSelected(color: Int) {
	       // use of color code here
            }

        })
bottomSheetDialog.show(supportFragmentManager, "color dialog")
```
