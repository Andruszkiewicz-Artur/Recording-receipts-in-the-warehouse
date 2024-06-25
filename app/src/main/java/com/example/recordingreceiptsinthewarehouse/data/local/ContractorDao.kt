package com.example.recordingreceiptsinthewarehouse.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.recordingreceiptsinthewarehouse.data.model.ContractorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContractorDao {

    @Upsert
    fun upsertContractor(contractorEntity: ContractorEntity)

    @Delete
    fun deleteContractor(contractorEntity: ContractorEntity)

    @Query("SELECT * FROM contractors")
    fun getAllContractors(): Flow<List<ContractorEntity>>

}