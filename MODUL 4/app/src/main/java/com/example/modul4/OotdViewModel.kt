package com.example.modul4

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class OotdViewModel : ViewModel() {

    private val _ootdList = MutableStateFlow<List<Ootd>>(emptyList())
    val ootdList: StateFlow<List<Ootd>> get() = _ootdList

    private val _selectedOotd = MutableStateFlow<Ootd?>(null)
    val selectedOotd: StateFlow<Ootd?> get() = _selectedOotd

    init {
        _ootdList.value = Ootd.ootdList
        Log.d("OotdViewModel", "Data dimuat ke dalam list: ${_ootdList.value.size} item")
    }

    fun selectOotd(ootd: Ootd) {
        _selectedOotd.value = ootd
        Log.d("OotdViewModel", "Item dipilih: ${ootd.title} (${ootd.gender})")
    }
}
