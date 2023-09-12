package com.example.modaldrawerecample.models

import android.os.Parcelable
import androidx.compose.ui.graphics.vector.ImageVector
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class MenuItemModel(val id:String, val title:String,
                         val iconVector: @RawValue ImageVector,
                         val contentDescription:String,
                         val onclick: () -> Unit) : Parcelable
