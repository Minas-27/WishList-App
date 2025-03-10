package com.example.mywishlist

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class WishViewModel: ViewModel(){
    var wishTitleState by mutableStateOf("")
    var wishDescriptionState by mutableStateOf("")

    fun onWishTitleStateChanged(newString : String){
        wishTitleState = newString
    }

    fun onWishDescriptionStateChanged(newString : String){
        wishDescriptionState = newString
    }
}
