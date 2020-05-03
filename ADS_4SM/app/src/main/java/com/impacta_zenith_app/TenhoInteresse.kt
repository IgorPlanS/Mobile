package com.impacta_zenith_app

class TenhoInteresse {
    var id: Long = 0
    var cliente: String = ""
    var datainteracao: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "TenhoInteresse(Cliente='$cliente')"
    }

}