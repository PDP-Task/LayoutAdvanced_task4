package com.example.layoutadvancedrecycleitemclick_task4

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class User(
    var name: String? = null,
    var age: String? = null
): Serializable
