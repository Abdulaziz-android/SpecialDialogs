package com.abdulaziz.specialdialogs

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.abdulaziz.special_dialogs.*
import com.abdulaziz.specialdialogs.databinding.ActivityMainBinding
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.basicButton.setOnClickListener {
            openBasicDialog()
        }

        binding.checkboxButton.setOnClickListener {
            openCheckBoxDialog()
        }

        binding.dateButton.setOnClickListener {
            openDateDialog()
        }

        binding.bottomSheetButton.setOnClickListener {
            openBasicBottomsheetDialog()
        }

        binding.bottomColorButton.setOnClickListener {
            openColorBottomSheetDialog()
        }


    }

    private fun openColorBottomSheetDialog(){
        val bottomSheetDialog = ColorBottomSheetDialog()
        bottomSheetDialog.setOnColorSelectedListener(object :ColorBottomSheetDialog.OnColorSelectListener{
            override fun OnColorSelected(color: Int) {
                binding.bottomColorButton.setBackgroundColor(color)
            }

        })
        bottomSheetDialog.show(supportFragmentManager, "color dialog")

    }


    private fun openBasicBottomsheetDialog(){
        val basicBottomSheetDialog = BasicBottomSheetDialog()
        basicBottomSheetDialog.build("Google Wifi", "Excellent", "Material Dialogs", "802.1x EAP")
        basicBottomSheetDialog.setOnConnectClickListener(object :BasicBottomSheetDialog.SetOnConnectClickListener{
            override fun OnConnectClicked(password: String) {
                Toast.makeText(this@MainActivity, "password $password", Toast.LENGTH_SHORT).show()
            }

        })
        basicBottomSheetDialog.show(supportFragmentManager, "bottomsheet dialog")
    }

    private fun openDateDialog() {
        val dateDialog = DateDialog()
        dateDialog.show(supportFragmentManager, "date dialog")
        dateDialog.setOnOkButtonClicked(object : DateDialog.OnButtonClicked{
            @RequiresApi(Build.VERSION_CODES.M)
            override fun OnOkButtonClicked(datePicker: DatePicker, timePicker: TimePicker) {
                val date = "${datePicker.dayOfMonth}.${datePicker.month}.${datePicker.year}  " +
                        "${timePicker.hour}:${timePicker.minute}"
                Toast.makeText(this@MainActivity, date, Toast.LENGTH_SHORT).show()
            }


        })
    }

    private fun openCheckBoxDialog(){
        val list = arrayListOf<String>("Telegram", "Instagram", "Facebook")

        val checkBoxDialog = CheckBoxDialog(list, "Social Networks")
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
    }

    private fun openBasicDialog(){
        val basicDialog = BasicDialog()
        basicDialog.build(resources.getString(R.string.basic_dialog_title), resources.getString(R.string.basic_dialog_message), resources.getString(R.string.basic_dialog_negative), resources.getString(R.string.basic_dialog_positive))
        basicDialog.show(supportFragmentManager, "dialog")
        basicDialog.setOnButtonClickListener(object : BasicDialog.DialogButtonsClickListener{
            override fun NegativeButtonClicked() {
                Toast.makeText(this@MainActivity, "DISAGREE", Toast.LENGTH_SHORT).show()
            }

            override fun PositiveButtonClicked() {
                Toast.makeText(this@MainActivity, "AGREE", Toast.LENGTH_SHORT).show()
            }

        })
    }

}