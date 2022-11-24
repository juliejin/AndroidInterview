package com.example.androidinterview.presentation.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidinterview.data.DiUtils
import com.example.androidinterview.data.model.Author
import kotlinx.coroutines.launch

class AuthorViewModel: ViewModel() {

    val repository = DiUtils.provideRepository()

    private val _authorLiveData = MutableLiveData<List<Author>>()

    fun getAuthorLiveData(): LiveData<List<Author>> = _authorLiveData

    fun fetchAuthorList() {
        viewModelScope.launch {
            _authorLiveData.postValue(repository.getAuthors())
        }
    }

}