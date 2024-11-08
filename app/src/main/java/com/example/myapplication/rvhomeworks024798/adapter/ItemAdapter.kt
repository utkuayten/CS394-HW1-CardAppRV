package com.example.myapplication.rvhomeworks024798.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.rvhomeworks024798.R
import com.example.myapplication.rvhomeworks024798.CardDetailActivity
import com.example.myapplication.rvhomeworks024798.model.Card

class ItemAdapter(private val data: List<Card>): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        private lateinit var card: Card

        private val nameView: TextView = view.findViewById(R.id.cardOwner)
        private val cardAmount: TextView = view.findViewById(R.id.cardAmount)
        private val cardType : TextView = view.findViewById(R.id.cardType)
        init {
            view.setOnClickListener{
                val context = itemView.context
                val showUserIntent = Intent(context, CardDetailActivity::class.java)
                showUserIntent.putExtra(CardDetailActivity.OWNER_NAME, card.name)
                showUserIntent.putExtra(CardDetailActivity.CARD_NUMBER, card.cardNumber)
                showUserIntent.putExtra(CardDetailActivity.CARD_TYPE, card.cardType)
                showUserIntent.putExtra(CardDetailActivity.CARD_AMOUNT, card.amount)
                context.startActivity(showUserIntent)
            }
        }
        fun bind(card: Card){
            this.card = card
            nameView.text = card.name
            cardAmount.text = card.amount
            cardType.text = card.cardType
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val user = data[position]
        holder.bind(user)

    }
}