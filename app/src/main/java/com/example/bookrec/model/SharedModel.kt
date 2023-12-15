package com.example.bookrec.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedModel:ViewModel() {

    val cartItem = MutableLiveData<ArrayList<PeceptModel>>()
    val bottonStates = ArrayList<Boolean>()

    fun getbottonStates(): List<Boolean>{
        return bottonStates
    }

    fun addToCart(item:PeceptModel){
        val currentCardItem = cartItem.value ?: ArrayList<PeceptModel>()
        currentCardItem.add(item)
        cartItem.value = currentCardItem
        bottonStates.add(true)
    }

    fun deleteFromCart(item: PeceptModel){
        val currentCardItem = cartItem.value ?: ArrayList<PeceptModel>()
        val index = currentCardItem.indexOf(item)
        if (index != -1){
            currentCardItem.removeAt(index)
            cartItem.value = currentCardItem
            bottonStates.removeAt(index)
        }
    }

    fun inList(item: PeceptModel):Boolean{
        val currentCardItem = cartItem.value ?: ArrayList<PeceptModel>()
        return  currentCardItem.contains(item)
    }

}