package edu.itesm.nytimes.mvvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.itesm.nytimes.BooksAPIService
import edu.itesm.nytimes.patterns.RetroFitSingleton
import edu.itesm.nytimes.response.Book
import edu.itesm.nytimes.response.BookResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListBooksViewModel: ViewModel() {
    var liveData : MutableLiveData<List<Book>>
    init{
        liveData = MutableLiveData()
    }
    fun getLiveDataObserver(): MutableLiveData<List<Book>>{
        return liveData
    }
    fun nyApiCall(){
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetroFitSingleton.getRetroFit().create(BooksAPIService::class.java)
                .getTopBooks("hardcover-fiction.json?api-key=dG3zskcMzfbDBYwPouwvApvRsCO4fpkh")
            call.enqueue(object : Callback<BookResponse> {
                override fun onResponse(call: Call<BookResponse>, response: Response<BookResponse>) {
                    liveData.postValue(response.body()?.results?.books?: emptyList())
                }

                override fun onFailure(call: Call<BookResponse>, t: Throwable) {
                    liveData.postValue(emptyList())
                }

            })
        }
    }
}
