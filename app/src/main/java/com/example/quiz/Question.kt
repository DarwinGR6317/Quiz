package com.example.quiz

import androidx.annotation.StringRes
//class Question{ }
data class  Question(@StringRes val textResId: Int, val answer: Boolean)