package com.impacta_zenith_app

class Agendamento {
    var id: Long = 0
    var cliente: String = ""
    var dataagendamento: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "Agendamento(Cliente='$cliente')"
    }

}