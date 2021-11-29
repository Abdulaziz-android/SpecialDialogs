package com.abdulaziz.special_dialogs

import android.app.Dialog
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BasicBottomSheetDialog : BottomSheetDialogFragment() {

    var wifiName= ""
    var signal:String=""
    var ssid:String=""
    var security:String=""
    var listener: SetOnConnectClickListener?=null


    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = BottomSheetDialog(requireContext())

        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.basic_bottomsheet_dialog, null)

        val wifiNameTV = view.findViewById<TextView>(R.id.wifi_tv)
        val signalTV = view.findViewById<TextView>(R.id.signal_tv)
        val ssidTV = view.findViewById<TextView>(R.id.ssid_tv)
        val securityTV = view.findViewById<TextView>(R.id.security_tv)
        val passwordET = view.findViewById<EditText>(R.id.password_et)
        wifiNameTV.text = wifiName
        signalTV.text = signal
        ssidTV.text = ssid
        securityTV.text = security


        val positiveTV = view.findViewById<TextView>(R.id.positive_btn)
        val negativeTV = view.findViewById<TextView>(R.id.negative_btn)

        positiveTV.setOnClickListener {
            listener?.OnConnectClicked(passwordET.text.toString())
            dismiss()
        }
        negativeTV.setOnClickListener {
            dismiss()
        }

        bottomSheetDialog.setContentView(view)

        return bottomSheetDialog
    }

    fun build(wifiName:String, signal:String, ssid:String, security:String){
        this.wifiName = wifiName
        this.signal = signal
        this.ssid = ssid
        this.security = security
    }

    fun setOnConnectClickListener(listener: SetOnConnectClickListener){
        this.listener = listener
    }

    interface SetOnConnectClickListener{
        fun OnConnectClicked(password:String)
    }
}