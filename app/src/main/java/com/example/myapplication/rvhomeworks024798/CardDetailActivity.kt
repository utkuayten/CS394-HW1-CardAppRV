package com.example.myapplication.rvhomeworks024798

import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.UnderlineSpan
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.rvhomeworks024798.databinding.ActivityCardDetailBinding
import java.util.Locale

class CardDetailActivity : AppCompatActivity() {
    companion object{
        const val OWNER_NAME = "card_name"
        const val CARD_NUMBER = "card_number"
        const val CARD_TYPE = "card_type"
        const val CARD_AMOUNT = "card_amount"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val binding: ActivityCardDetailBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_card_detail
        )

        val userName = intent.getStringExtra(OWNER_NAME)?.uppercase()
        val cardNumber = intent.getStringExtra(CARD_NUMBER)
        val cardType = intent.getStringExtra(CARD_TYPE)
        val cardAmount = intent.getStringExtra(CARD_AMOUNT)


        val formattedCardNumber = cardNumber?.chunked(4)?.joinToString(" - ") ?: ""
        val spannable = SpannableString(cardType)
        if (cardType != null) {
            spannable.setSpan(UnderlineSpan(), 0, cardType.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        }


        binding.nameView.text  = userName
        binding.cardNumber.text = formattedCardNumber
        binding.cardType.text = spannable
        binding.cardAmount.text = cardAmount

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}