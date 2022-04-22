package com.hazem.androidmvistarter.data.remote.meals

import android.os.Parcelable
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

@JsonClass(generateAdapter = true)
@Parcelize
data class Meal(
    val filter: String?,
    val image: String?,
    val title: String?
) : Parcelable {
    // beautify the returned tags from the api
    fun getFormattedTags():String{
        var tags = arrayListOf<String>()
        filter?.split(',')?.onEach {
            var tag: String = it.replaceBeforeLast(':',"")
            tag = tag.replaceAfterLast("\\","")
            tag = tag.replace("\\","")
            tag = tag.replace(":","")
            tags.add(tag)
        }

        return tags.joinToString(separator = ", ") { it }
    }
}