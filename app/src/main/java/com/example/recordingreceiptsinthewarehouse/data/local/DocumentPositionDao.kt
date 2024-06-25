package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity

@Dao
interface DocumentPositionDao {

    @Upsert
    fun upsertDocumentPosition(documentEntity: DocumentEntity)

    @Delete
    fun deleteDocumentPosition(documentEntity: DocumentEntity)

}