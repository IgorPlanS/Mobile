package com.impacta_zenith_app

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import androidx.room.Database
import com.google.gson.reflect.TypeToken
import java.net.URL

object AgendamentoService {

    val host = "https://igorplanpy.pythonanywhere.com/"
    val TAG = "WS_LMSApp"

    fun getAgendamento(context: Context): List<Agendamento>{

        if(AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/agendamento"
            val json = URL(url).readText()
            Log.d(TAG, json)
            var agendamento = parserJson<List<Agendamento>>(json)
            for (d in agendamento){
                saveOffline(d)
            }
            return agendamento
        }
        else{
            var dao = DatabaseManager.getAgendamentoDAO()
            return dao.findAll()
        }
    }

    fun saveOffline(agendamento: Agendamento): Boolean{
        val dao = DatabaseManager.getAgendamentoDAO()

        if (! existeAgendamento(agendamento)){
            dao.insert(agendamento)
        }
        return true
    }

    fun existeAgendamento(agendamento: Agendamento):Boolean{
        val dao = DatabaseManager.getAgendamentoDAO()
        return dao.getById(agendamento.id) != null
    }

    inline fun <reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}