package com.rojas.navlab.model

import androidx.annotation.DrawableRes

data class Student(
    val id: Int,
    val name: String,
    val career: String,
    val code: String,
    val email: String,
    val faculty: String,
    val bio: String,
    @param:DrawableRes val avatar: Int
)
