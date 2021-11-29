package com.abdulaziz.special_dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialogFragment
import androidx.core.content.ContextCompat
import androidx.core.view.forEach
import androidx.core.widget.CompoundButtonCompat


class CheckBoxDialog(val list: List<String>, val title: String) : AppCompatDialogFragment() {

    var listener: OnChooseClickListener? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val inflater = activity?.layoutInflater!!

        val view = inflater.inflate(R.layout.checkbox_dialog, null)
        val linear = view.findViewById<LinearLayout>(R.id.linear)

        list.forEachIndexed { index, s ->
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 30, 0, 0)

            val checkBox = CheckBox(activity)
            checkBox.tag = s
            checkBox.text = s
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                checkBox.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(
                    requireActivity(),
                    R.color.design_default_color_primary))
            } else {
                CompoundButtonCompat.setButtonTintList(checkBox,
                    ColorStateList.valueOf(ContextCompat.getColor(requireActivity(),
                        R.color.design_default_color_primary)))
            }
            checkBox.layoutParams = params
            linear.addView(checkBox)
        }
        builder.setView(view)
        val titleTV = view.findViewById<TextView>(R.id.title_tv)
        val chooseTV = view.findViewById<TextView>(R.id.choose_tv)
        chooseTV.setOnClickListener {
            val list = arrayListOf<String>()
            linear.forEach {
                val checkBox = it as CheckBox
                if (checkBox.isChecked) {
                    list.add(checkBox.text.toString())
                }
            }
            listener?.chooseClick(list)
            dismiss()
        }

        titleTV.text = title

        return builder.create()
    }

    fun setOnChooseClickListener(listener: OnChooseClickListener) {
        this.listener = listener
    }

    interface OnChooseClickListener {
        fun chooseClick(chosenList: List<String>)
    }

}