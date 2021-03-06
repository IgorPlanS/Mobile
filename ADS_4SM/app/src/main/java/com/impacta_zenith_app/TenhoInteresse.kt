package com.impacta_zenith_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "tenhointeresse")
class TenhoInteresse {

    @PrimaryKey
    var id: Long = 0
    var cliente: String = ""
    var datainteracao: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "TenhoInteresse(Cliente='$cliente')"
    }

}