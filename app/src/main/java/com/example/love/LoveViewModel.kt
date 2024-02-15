package com.example.love

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository): ViewModel(){

    fun getLove(firstName: String, secondName: String): LiveData<LoveModel> {
        return repository.getLoveModel(firstName = firstName, secondName = secondName)
    }
}