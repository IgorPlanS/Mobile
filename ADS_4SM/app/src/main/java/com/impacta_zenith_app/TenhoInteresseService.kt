package com.impacta_zenith_app

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object TenhoInteresseService {

    val host = "https://igorplanpy.pythonanywhere.com/"
    val TAG = "WS_LMSApp"

    fun getTenhoInteresse(context: Context): List<TenhoInteresse>{
        if(AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/tenhointeresse"
            val json = URL(url).readText()
            Log.d(TAG, json)
            var tenhointeresse = parserJson<List<TenhoInteresse>>(json)
            for (d in tenhointeresse){
                saveOffline(d)
            }
            return tenhointeresse
        }
        else{
            var dao = DatabaseManager.getTenhoInteresseDAO()
            return dao.findAll()
        }
    }

    fun saveOffline(tenhointeresse: TenhoInteresse): Boolean{
        val dao = DatabaseManager.getTenhoInteresseDAO()

        if (! existeTenhoInteresse(tenhointeresse)){
            dao.insert(tenhointeresse)
        }
        return true
    }

    fun existeTenhoInteresse(tenhointeresse: TenhoInteresse):Boolean{
        val dao = DatabaseManager.getTenhoInteresseDAO()
        return dao.getById(tenhointeresse.id) != null
    }

    inline fun <reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}