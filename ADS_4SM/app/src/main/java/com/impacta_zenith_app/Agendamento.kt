package com.impacta_zenith_app

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName = "agendamento")
class Agendamento {

    @PrimaryKey
    var id: Long = 0
    var cliente: String = ""
    var dataagendamento: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "Agendamento(Cliente='$cliente')"
    }

}