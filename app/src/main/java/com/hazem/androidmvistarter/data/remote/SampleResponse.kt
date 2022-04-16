package com.hazem.androidmvistarter.data.remote
import com.squareup.moshi.Json
import kotlinx.serialization.Serializable

@Serializable
class SampleResponse : ArrayList<SampleResponse.SampleResponseItem>(){
    @Serializable
    data class SampleResponseItem(
        @Json(name = "date")
        val date: String?,
        @Json(name = "dayText")
        val dayText: String?,
        @Json(name = "dptMax")
        val dptMax: Int?,
        @Json(name = "dptMin")
        val dptMin: Int?,
        @Json(name = "inHealthyEatingZone")
        val inHealthyEatingZone: Boolean?,
        @Json(name = "pointsUsed")
        val pointsUsed: Int?
    )
}