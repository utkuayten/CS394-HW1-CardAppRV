package com.example.myapplication.rvhomeworks024798.data

import android.content.Context
import com.example.myapplication.rvhomeworks024798.R

import com.example.myapplication.rvhomeworks024798.model.Card

class DataSource(val context: Context) {


    private fun getFirstNameList(): Array<String>{
        return context.resources.getStringArray(R.array.first_name_array)
    }

    private fun getLastNameList(): Array<String> {
        return context.resources.getStringArray(R.array.last_name_array)
    }

    private fun getUserNamesList(): Array<String> {
        val firstNames = getFirstNameList()
        val lastNames = getLastNameList()
        return firstNames.zip(lastNames) { firstName, lastName -> "$firstName $lastName" }
            .toTypedArray()
    }

    private fun getCardNumberList(): Array<String> {
        return context.resources.getStringArray(R.array.card_number)
    }

    private fun getCardTypeList(): Array<String> {
        return context.resources.getStringArray(R.array.card_type)
    }

    private fun getCardAmount(): Array<String> {
        return context.resources.getStringArray(R.array.amount)
    }


    fun loadCards(): List<Card>{
        val namesList = getUserNamesList()
        val cardNumbers = getCardNumberList()
        val cardTypes = getCardTypeList()
        val cardAmount = getCardAmount()


        val cards = mutableListOf<Card>()
        for (i in namesList.indices){
            cards.add(
                Card(name = namesList[i],
                    cardNumber = cardNumbers[i],
                    cardType = cardTypes[i],
                    amount = cardAmount[i])
            )}
        return cards
    }
}