package com.example.submissionapplication

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laptop(
    val laptop_name: String,
    val laptop_highlights: String,
    val laptop_picture: String,
    val laptop_cpu: String,
    val laptop_os: String,
    val laptop_ram: String,
    val laptop_storage: String,
    val laptop_screen:String,
    val laptop_gpu: String,
    val laptop_features: String,
    val laptop_price: Int,
) : Parcelable
