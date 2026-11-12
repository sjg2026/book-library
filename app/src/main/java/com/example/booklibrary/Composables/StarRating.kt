package com.example.booklibrary.Composables

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Row


@Composable
fun StarRating(rating:Int,onRatingChanged:(Int) -> Unit ){
    Row (){
        for (i in 1 .. 5){
           // val icon = if (i<= rating)
        }
    }
}