package com.example.databinding_.viewmodel

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val quoteLiveData = MutableLiveData("Click on the button below, " +
            "to fetch the data from the live data defined in view model")
    fun updateQuote(){
        quoteLiveData.value = "Hey!! This is the data fetched from the live data and " +
                "viewed on the text view"
    }
}