package com.impacta_zenith_app

import android.content.Context

object TenhoInteresseService {

    fun getTenhoInteresse(context: Context): List<TenhoInteresse>{
        val l_tenhointeresse = mutableListOf<TenhoInteresse>()

        for (i in 1..10){
            val a = TenhoInteresse()
            a.cliente = "Cliente $i"
            if (i == 1){
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 01/10/2020"
            }
            else if (i == 2){
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 05/10/2020"
            }
            else if (i == 3){
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 15/10/2020"
            }
            else if (i == 4){
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 21/10/2020"
            }
            else if (i == 5){
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 24/10/2020"
            }
            else {
                a.foto = "https://www.pngkit.com/png/full/358-3586521_atendimento-ao-cliente-vetor-vetor-cliente-png.png"
                a.datainteracao = "Data intereção: 30/10/2020"
            }
            l_tenhointeresse.add(a)
        }
        return l_tenhointeresse
    }

}