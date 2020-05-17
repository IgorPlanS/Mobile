package com.impacta_zenith_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FaleConoscoDAO {

    @Query("SELECT * FROM faleconosco WHERE id = :id")
    fun getById(id: Long):FaleConosco?

    @Query("SELECT * FROM faleconosco")
    fun findAll(): List<FaleConosco>

    @Insert
    fun insert(faleConosco: FaleConosco)

    @Delete
    fun delete(faleConosco: FaleConosco)

}