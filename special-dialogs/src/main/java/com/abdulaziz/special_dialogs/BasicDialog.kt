package com.abdulaziz.special_dialogs

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDialogFragment
import java.lang.ClassCastException

class BasicDialog:AppCompatDialogFragment() {

    private var listener: DialogButtonsClickListener?=null

    var title = ""
    var message = ""
    var negativeButtonText: String = ""
    var positiveButtonText: String = ""

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(activity)
        val layoutInflater = activity?.layoutInflater

        val view = layoutInflater?.inflate(R.layout.basic_dialog, null)!!
        builder.setView(view)

        val titleTV:TextView = view.findViewById(R.id.title_tv)
        val messageTV:TextView = view.findViewById(R.id.message_tv)
        val positiveTV:TextView = view.findViewById(R.id.positive_btn)
        val negativeTV:TextView = view.findViewById(R.id.negative_btn)

        titleTV.text = title
        messageTV.text = message
        positiveTV.text = positiveButtonText
        negativeTV.text = negativeButtonText

        negativeTV.setOnClickListener {
            dismiss()
            listener?.NegativeButtonClicked()
        }
        positiveTV.setOnClickListener {
            dismiss()
            listener?.PositiveButtonClicked()
        }

        return builder.create()
    }

    fun build(  title: String,
                message: String,
                negativeButtonText: String,
                positiveButtonText: String){
        this.title = title
        this.message = message
        this.negativeButtonText = negativeButtonText
        this.positiveButtonText = positiveButtonText
    }

    fun setOnButtonClickListener(listener:DialogButtonsClickListener){
        this.listener = listener
    }


    interface DialogButtonsClickListener{
        fun NegativeButtonClicked()
        fun PositiveButtonClicked()
    }
}