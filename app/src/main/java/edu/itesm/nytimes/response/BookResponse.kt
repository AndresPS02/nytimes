package edu.itesm.nytimes.response
import com.google.gson.annotations.SerializedName

data class BookResponse(
    @SerializedName("results") var results: ResultsResponse
)
