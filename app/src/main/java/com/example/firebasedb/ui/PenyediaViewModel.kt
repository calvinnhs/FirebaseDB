package com.example.firebasedb.ui

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.firebasedb.KontakAplication
import com.example.firebasedb.ui.add.AddViewModel

fun CreationExtras.aplikasiKontak(): KontakAplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as KontakAplication)

object PenyediaViewModel{
    val Factory = viewModelFactory {
        initializer {
            AddViewModel(aplikasiKontak().container.kontakRepository)
        }
    }
}