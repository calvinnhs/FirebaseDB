package com.example.firebasedb.ui

import com.example.firebasedb.model.kontak


data class UIStateKontak(
    val detailKontak: DetailKontak = DetailKontak(),
)

data class DetailKontak(
    val id: String = "",
    val nama: String = "",
    val alamat: String = "",
    val telpon: String = "",
)

fun DetailKontak.toKontak(): kontak = kontak(
    id = id,
    nama = nama,
    alamat = alamat,
    telepon = telpon,
)

fun kontak.toUiStateKontak(isEntryValid: Boolean = false): UIStateKontak = UIStateKontak(
    detailKontak = this.toDetailKontak(),
)

fun kontak.toDetailKontak(): DetailKontak = DetailKontak(
    id = id,
    nama = nama,
    alamat = alamat,
    telpon = telepon,
)

data class HomeUiState(
    val listSiswa: List<kontak> = listOf()
)

