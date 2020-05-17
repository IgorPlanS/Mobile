package com.impacta_zenith_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TenhoInteresseDAO {

    @Query("SELECT * FROM tenhointeresse WHERE id = :id")
    fun getById(id: Long):TenhoInteresse?

    @Query("SELECT * FROM tenhointeresse")
    fun findAll(): List<TenhoInteresse>

    @Insert
    fun insert(tenhointeresse: TenhoInteresse)

    @Delete
    fun delete(tenhointeresse: TenhoInteresse)

}