package com.abdulaziz.special_dialogs.adapter

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.abdulaziz.special_dialogs.R

class ColorAdapter(val list: List<Int>, val listener: OnItemClickListener) :
    RecyclerView.Adapter<ColorAdapter.ColorIV>() {

    var item: CardView? = null
    var lastPosition = 0
    private val TAG = "ColorAdapter"

    inner class ColorIV(itemView: View) : RecyclerView.ViewHolder(itemView.rootView) {
        fun onBind(color: Int, position: Int) {
            Log.d(TAG, "onBind: $position")

            val cardView = itemView.findViewById<CardView>(R.id.card_view)
            val backCard = itemView.findViewById<CardView>(R.id.back_card)
            cardView.setCardBackgroundColor(color)

            itemView.setOnClickListener {
                listener.OnItemClicked(color)
                if (item != null) {
                    if (lastPosition != position) {
                        item!!.setCardBackgroundColor(Color.WHITE)
                        item = backCard
                        lastPosition = position
                        backCard.setCardBackgroundColor(Color.BLACK)
                    } else backCard.setCardBackgroundColor(Color.BLACK)
                } else {
                    item = backCard
                    lastPosition = position
                    backCard.setCardBackgroundColor(Color.BLACK)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ColorIV {
        return ColorIV(LayoutInflater.from(parent.context)
            .inflate(R.layout.item_color, parent, false))
    }

    override fun onBindViewHolder(holder: ColorIV, position: Int) {
        holder.onBind(list[position], position)
    }

    override fun getItemCount(): Int = list.size

    interface OnItemClickListener {
        fun OnItemClicked(color: Int)
    }
}