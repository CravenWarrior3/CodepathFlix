package ecooper.myapplication

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("poster_path")
    val posterURL: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val description: String? = null
) {

}