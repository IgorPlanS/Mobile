package com.impacta_zenith_app

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDAO {

    @Query("SELECT * FROM usuarios WHERE id = :id")
    fun getById(id: Long):Usuarios?

    @Query("SELECT * FROM usuarios")
    fun findAll(): List<Usuarios>

    @Insert
    fun insert(usuarios: Usuarios)

    @Delete
    fun delete(usuarios: Usuarios)

}