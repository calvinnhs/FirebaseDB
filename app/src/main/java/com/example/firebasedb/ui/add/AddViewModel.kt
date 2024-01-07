package com.example.firebasedb.ui.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.firebasedb.data.KontakRepositori
import com.example.firebasedb.ui.DetailKontak
import com.example.firebasedb.ui.UIStateKontak
import com.example.firebasedb.ui.toKontak

class AddViewModel(private val kontakRepository: KontakRepositori) : ViewModel() {

    var uiStateKontak by mutableStateOf(UIStateKontak())
        private set

    fun updateUiState(detailKontak: DetailKontak) {
        uiStateKontak = UIStateKontak(detailKontak = detailKontak)
    }

    suspend fun saveKontak() {
        kontakRepository.save(uiStateKontak.detailKontak.toKontak())
    }
}