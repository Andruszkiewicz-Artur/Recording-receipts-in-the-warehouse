package com.example.recordingreceiptsinthewarehouse.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.recordingreceiptsinthewarehouse.data.local.DocumentsDatabase
import com.example.recordingreceiptsinthewarehouse.data.repository.DocumentRepositoryImpl
import com.example.recordingreceiptsinthewarehouse.domain.repository.DocumentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideIntervalTimeDatabase(@ApplicationContext context: Context): DocumentsDatabase {
        return Room.databaseBuilder(
            context,
            DocumentsDatabase::class.java,
            DocumentsDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideDocumentRepository(db: DocumentsDatabase): DocumentRepository {
        return DocumentRepositoryImpl(db.documentDao, db.contractorDao, db.documentPositionDao)
    }

}