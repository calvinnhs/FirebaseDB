package com.example.firebasedb.data

import android.content.ContentValues
import android.util.Log
import com.example.firebasedb.model.kontak
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.tasks.await

interface KontakRepositori {
    fun getAll(): Flow<List<kontak>>
    suspend fun save(kontak: kontak): String
    suspend fun update(kontak: kontak)
    suspend fun delete(kontakId: String)

    fun getKontakById(kontakId: String): Flow<kontak>
}

class KontakRepositoriImpl(private val firestore: FirebaseFirestore) : KontakRepositori {
    override fun getAll(): Flow<List<kontak>> = flow {
        val snapshot = firestore.collection("Kontak")
            .orderBy("nama", Query.Direction.ASCENDING)
            .get()
            .await()
        val kontak = snapshot.toObjects(kontak::class.java)
        emit(kontak)
    }.flowOn((Dispatchers.IO))

    override suspend fun save(kontak: kontak): String {
        return try {
            val documentReference = firestore.collection("Kontak").add(kontak).await()

            firestore.collection("Kontak").document(documentReference.id)
                .set(kontak.copy(id = documentReference.id))
            "Berhasil + ${documentReference.id}"
        } catch (e: Exception) {
            Log.w(ContentValues.TAG, "Error adding document", e)
            "Gagal $e"
        }
    }

    override suspend fun update(kontak: kontak) {
        firestore.collection("Kontak").document(kontak.id).set(kontak).await()

    }

    override suspend fun delete(kontakId: String) {
        firestore.collection("Kontak").document(kontakId).delete().await()
    }

    override fun getKontakById(kontakId: String): Flow<kontak> {
        return flow {
            val snapshot = firestore.collection("Kontak").document(kontakId).get().await()
            val kontak = snapshot.toObject(kontak::class.java)
            emit(kontak!!)
        }.flowOn(Dispatchers.IO)

    }

}