package edu.itesm.nytimes.response

import com.google.gson.annotations.SerializedName

data class Book(
    @SerializedName("description") var description: String,
    @SerializedName("title") var title: String,
    @SerializedName("book_image") var imageUrl: String
)
