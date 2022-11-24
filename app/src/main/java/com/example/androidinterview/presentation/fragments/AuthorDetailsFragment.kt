package com.example.androidinterview.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.androidinterview.data.model.Author
import com.example.androidinterview.databinding.FragmentAuthorDetailsBinding

class AuthorDetailsFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentAuthorDetailsBinding.inflate(inflater)
        val args = arguments?.get("author") as? Author
        binding.authorName.text = args?.name
        Glide.with(context)
            .load(args?.iconUrl)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(binding.authorIcon)
        return binding.root
    }
}