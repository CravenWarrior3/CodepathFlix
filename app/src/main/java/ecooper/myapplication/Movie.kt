package ecooper.myapplication

import com.google.gson.annotations.SerializedName

class Movie (
    @SerializedName("poster_path")
    val posterURL: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("overview")
    val description: String? = null,
    @SerializedName("release_date")
    val release: String? = null,
    @SerializedName("vote_average")
    val rating: String? = null,
    @SerializedName("vote_count")
    val ratingCount: String? = null
) {

}