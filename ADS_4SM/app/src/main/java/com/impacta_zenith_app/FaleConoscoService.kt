package com.impacta_zenith_app

import android.content.Context
import android.util.Log
import androidx.room.Database
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object FaleConoscoService {

    val host = "https://igorplanpy.pythonanywhere.com/"
    val TAG = "WS_LMSApp"

    fun getFaleConosco(context: Context): List<FaleConosco>{

        if(AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/faleconosco"
            val json = URL(url).readText()
            Log.d(TAG, json)
            var faleconosco = parserJson<List<FaleConosco>>(json)
            for (d in faleconosco){
                saveOffline(d)
            }
            return faleconosco
        }
        else{
            var dao = DatabaseManager.getFaleConoscoDAO()
            return dao.findAll()
        }

    }

    fun saveOffline(faleConosco: FaleConosco): Boolean{
        val dao = DatabaseManager.getFaleConoscoDAO()

        if(! existeFaleConosco(faleConosco)){
            dao.insert(faleConosco)
        }
        return true
    }

    fun existeFaleConosco(faleConosco: FaleConosco):Boolean{
        val dao = DatabaseManager.getFaleConoscoDAO()
        return dao.getById(faleConosco.id) != null
    }

    inline fun <reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}