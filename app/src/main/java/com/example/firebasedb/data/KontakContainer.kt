package com.example.firebasedb.data

import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val kontakRepository : KontakRepositori
}


class kontakContainer : AppContainer{
    private val firestore : FirebaseFirestore = FirebaseFirestore.getInstance()

    override val kontakRepository: KontakRepositori by lazy {
        KontakRepositoriImpl(firestore)
    }
}