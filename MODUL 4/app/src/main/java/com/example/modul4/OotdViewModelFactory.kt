package com.example.modul4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class OotdViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OotdViewModel::class.java)) {
            return OotdViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
