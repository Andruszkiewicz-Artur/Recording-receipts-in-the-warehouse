package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentEntity
import com.example.recordingreceiptsinthewarehouse.data.model.DocumentPositionEntity

@Database(
    entities = [DocumentEntity::class, ContractorEntity::class, DocumentPositionEntity::class],
    version = 1
)
abstract class DocumentsDatabase: RoomDatabase() {

    abstract val documentDao: DocumentDao
    abstract val contractorDao: ContractorDao
    abstract val documentPositionDao: DocumentPositionDao

    companion object {
        const val DATABASE_NAME = "DocumentsDatabase"
    }
}