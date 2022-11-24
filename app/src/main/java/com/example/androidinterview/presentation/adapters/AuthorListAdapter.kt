package com.example.androidinterview.presentation.adapters

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.androidinterview.R
import com.example.androidinterview.data.model.Author
import com.example.androidinterview.databinding.AuthorItemViewBinding

class AuthorListAdapter(val authorList: List<Author>): RecyclerView.Adapter<AuthorListAdapter.AuthorViewHolder>() {

    class AuthorViewHolder(val parent: ViewGroup, val itemBinding: AuthorItemViewBinding): RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(author: Author) {
            itemBinding.authorName.text = author.name
            Glide.with(parent.context)
                .load(author.iconUrl)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(itemBinding.authorIcon)
            itemBinding.root.setOnClickListener {
                val bundle = bundleOf("author" to author)
                val navController = parent.findNavController()
                navController.navigate(R.id.authorDetailFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        return AuthorViewHolder(
            parent,
            AuthorItemViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        holder.bind(authorList[position])
    }

    override fun getItemCount(): Int {
        return authorList.size
    }
}