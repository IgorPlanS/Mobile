package com.impacta_zenith_app

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder

@Entity (tableName = "usuarios")
class Usuarios {

    @PrimaryKey
    var id: Long = 0
    var usuario: String = ""
    var password: String = ""

    override fun toString(): String{
        return "$usuario$password"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }

}