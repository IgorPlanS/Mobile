package com.impacta_zenith_app

import android.content.Context

object AgendamentoService {

    fun getAgendamento(context: Context): List<Agendamento>{
        val l_agendamentos = mutableListOf<Agendamento>()

        for (i in 1..10){
            val a = Agendamento()
            a.cliente = "Cliente $i"
                if (i == 1){
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon3_101149.png"
                    a.dataagendamento = "Data visita: 01/10/2020"
                }
                else if (i == 2){
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon2_101152.png"
                    a.dataagendamento = "Data visita: 05/10/2020"
                }
                else if (i == 3){
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon3_101149.png"
                    a.dataagendamento = "Data visita: 15/10/2020"
                }
                else if (i == 4){
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon2_101152.png"
                    a.dataagendamento = "Data visita: 21/10/2020"
                }
                else if (i == 5){
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon3_101149.png"
                    a.dataagendamento = "Data visita: 24/10/2020"
                }
                else {
                    a.foto = "https://cdn.icon-icons.com/icons2/1470/PNG/512/icon3_101149.png"
                    a.dataagendamento = "Data visita: A acertar com cliente"
                }
            l_agendamentos.add(a)
        }
        return l_agendamentos
    }

}