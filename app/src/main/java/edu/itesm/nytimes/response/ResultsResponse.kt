package edu.itesm.nytimes.response

import com.google.gson.annotations.SerializedName


data class ResultsResponse(
    @SerializedName("books") var books: List<Book>
)