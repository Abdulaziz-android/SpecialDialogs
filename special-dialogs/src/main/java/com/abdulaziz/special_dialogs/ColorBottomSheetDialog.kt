package com.abdulaziz.special_dialogs

import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.abdulaziz.special_dialogs.adapter.ColorAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout

class ColorBottomSheetDialog : BottomSheetDialogFragment() {

    var listener: OnColorSelectListener? = null
    var selectedColor: Int? = null

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.color_bottomsheet_dialog, null)

        val positiveButton = view.findViewById<TextView>(R.id.positive_btn)
        val negativeButton = view.findViewById<TextView>(R.id.negative_btn)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)
        val recyclerView = view.findViewById<RecyclerView>(R.id.rv)

        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addTab(tabLayout.newTab())
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                /*  if (tab!!.position == 0) {
                      datePicker.visibility = View.VISIBLE
                      timePicker.visibility = View.GONE
                  } else {
                      datePicker.visibility = View.GONE
                      timePicker.visibility = View.VISIBLE
                  }*/
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        val list = arrayListOf<Int>(-0xbbcca,
            -0x16e19d,
            -0x63d850,
            -0x98c549,
            -0xc0ae4b,
            -0xde690d,
            -0xfc560c,
            -0xff432c,
            -0xff6978,
            -0xb350b0,
            -0x743cb6,
            -0x3223c7,
            -0x14c5,
            -0x3ef9,
            -0x6800,
            -0xa8de)


        val adapter = ColorAdapter(list, object : ColorAdapter.OnItemClickListener {
            override fun OnItemClicked(color: Int) {
                selectedColor = color
                positiveButton.setTextColor(ContextCompat.getColor(requireContext(),
                    R.color.design_default_color_primary))
            }

        })

        recyclerView.adapter = adapter

        positiveButton.setOnClickListener {
            if (selectedColor != null) {
                listener?.OnColorSelected(selectedColor!!)
                dismiss()
            }
        }
        negativeButton.setOnClickListener {
            dismiss()
        }

        bottomSheetDialog.setContentView(view)

        return bottomSheetDialog
    }

    fun setOnColorSelectedListener(listener: OnColorSelectListener) {
        this.listener = listener
    }


    interface OnColorSelectListener {
        fun OnColorSelected(color: Int)
    }

}