package com.example.firebasedb.model

data class kontak (
    val id: String,
    val nama: String,
    val alamat: String,
    val telepon: String
){
    constructor(): this("", "", "","")
}