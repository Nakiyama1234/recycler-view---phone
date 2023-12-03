package com.naufal.aplikasiandroidsederhana

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class HP(
    val nameHP: String,
    val deskripsi: String,
    val fotoHP: Int
): Parcelable
