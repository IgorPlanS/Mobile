package com.impacta_zenith_app

class FaleConosco {
    var id: Long = 0
    var cliente: String = ""
    var datacomentario: String = ""
    var foto: String = ""

    override fun toString(): String{
        return "FaleConosco(Cliente='$cliente')"
    }

}