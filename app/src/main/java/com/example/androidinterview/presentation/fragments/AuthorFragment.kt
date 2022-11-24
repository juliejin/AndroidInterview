package com.example.androidinterview.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.androidinterview.databinding.FragmentAuthorBinding
import com.example.androidinterview.presentation.adapters.AuthorListAdapter
import com.example.androidinterview.presentation.viewmodels.AuthorViewModel

class AuthorFragment: Fragment() {

    val authorViewModel by viewModels<AuthorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val binding = FragmentAuthorBinding.inflate(inflater)
        authorViewModel.getAuthorLiveData().observe(viewLifecycleOwner) {
            binding.authorList.adapter = AuthorListAdapter(it)
            binding.authorList.adapter?.notifyDataSetChanged()
        }
        authorViewModel.fetchAuthorList()
        return binding.root
    }

}