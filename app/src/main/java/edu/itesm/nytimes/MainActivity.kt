package edu.itesm.nytimes

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import edu.itesm.nytimes.adapter.BooksAdapter
import edu.itesm.nytimes.databinding.ActivityMainBinding
import edu.itesm.nytimes.mvvvm.ListBooksViewModel
import edu.itesm.nytimes.response.Book
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: BooksAdapter
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ListBooksViewModel

    private val books = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        initAdapter()
        initViewModel()
        consultNY()
    }

    private fun initAdapter() {
        this.adapter = BooksAdapter(books)
        this.binding.recyclerView.layoutManager = LinearLayoutManager(this)
        this.binding.recyclerView.adapter = this.adapter
    }

    private fun initViewModel() {
        this.viewModel = ViewModelProvider(this).get(ListBooksViewModel::class.java)
        this.viewModel.getLiveDataObserver().observe(this, Observer {
            if (it.isNotEmpty()) {
                adapter.setBooks(it)
                adapter.notifyDataSetChanged()
            }
        })
    }

    private fun consultNY() {
        this.viewModel.nyApiCall()
    }

}