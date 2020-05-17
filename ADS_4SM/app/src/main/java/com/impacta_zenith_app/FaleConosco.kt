package com.impacta_zenith_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "faleconosco")
class FaleConosco {

    @PrimaryKey
    var id: Long = 0
    var cliente: String = ""
    var datacomentario: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "FaleConosco(Cliente='$cliente')"
    }

}