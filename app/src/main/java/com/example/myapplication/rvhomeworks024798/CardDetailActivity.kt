package com.example.myapplication.rvhomeworks024798

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.rvhomeworks024798.databinding.ActivityUserDetailBinding

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
        //setContentView(R.layout.activity_user_detail)
        val binding: ActivityUserDetailBinding = DataBindingUtil.setContentView(this,
            R.layout.activity_user_detail
        )

        val userName = intent.getStringExtra(OWNER_NAME)
        val cardNumber = intent.getStringExtra(CARD_NUMBER)
        val cardType = intent.getStringExtra(CARD_TYPE)
        val cardAmount = intent.getStringExtra(CARD_AMOUNT)

        binding.nameView.text  = userName
        binding.cardNumber.text = cardNumber
        binding.cardType.text = cardType

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}