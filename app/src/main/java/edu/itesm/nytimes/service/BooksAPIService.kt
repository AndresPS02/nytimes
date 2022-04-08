package edu.itesm.nytimes

import edu.itesm.nytimes.response.BookResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url


interface BooksAPIService {
    // @GET("hardcover-fiction.json?api-key=dG3zskcMzfbDBYwPouwvApvRsCO4fpkh")
    @GET
    fun getTopBooks(@Url url: String):
            Call<BookResponse>

}