package com.impacta_zenith_app

import android.content.Context

object FaleConoscoService {

    fun getFaleConosco(context: Context): List<FaleConosco>{
        val l_faleconosco = mutableListOf<FaleConosco>()

        for (i in 1..10){
            val a = FaleConosco()
            a.cliente = "Cliente $i"
                if (i == 1){
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: 01/10/2020"
                }
                else if (i == 2){
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: 05/10/2020"
                }
                else if (i == 3){
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: 15/10/2020"
                }
                else if (i == 4){
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: 21/10/2020"
                }
                else if (i == 5){
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: 24/10/2020"
                }
                else {
                    a.foto = "https://uploaddeimagens.com.br/images/002/628/092/full/ic_comentario.png"
                    a.datacomentario = "Data comentário: A acertar com cliente"
                }
            l_faleconosco.add(a)
        }
        return l_faleconosco
    }

}