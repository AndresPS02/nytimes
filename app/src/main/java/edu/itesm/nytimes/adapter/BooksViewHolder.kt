package edu.itesm.nytimes.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import edu.itesm.nytimes.databinding.ListNyBookBinding
import edu.itesm.nytimes.response.Book

class BooksViewHolder (view : View) : RecyclerView.ViewHolder(view){
    private val binding = ListNyBookBinding.bind(itemView)
    fun bind(book: Book){
        binding.tvTitle.text = book.title
        binding.tvDescription.text = book.description
        Glide.with(binding.root)
            .load(book.imageUrl).centerCrop()
            .into(binding.imageView)
        //Picasso.get().load(imageString).into(binding.fotoPerro)
    }

}