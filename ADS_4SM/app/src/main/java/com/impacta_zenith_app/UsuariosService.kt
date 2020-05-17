package com.impacta_zenith_app

import android.content.Context
import android.util.Log
import br.com.fernandosousa.lmsapp.HttpHelper
import br.com.fernandosousa.lmsapp.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object UsuariosService {

    val host = "https://igorplanpy.pythonanywhere.com/"
    val TAG = "WS_LMSApp"

    fun getUsuarios(context: Context): List<Usuarios>{

        if(AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/usuarios"
            val json = HttpHelper.get(url)
            Log.d(TAG, json)
            var usuarios = parserJson<List<Usuarios>>(json)
            for (d in usuarios){
                saveOffline(d)
            }
            return usuarios
        }
        else{
            var dao = DatabaseManager.getUsuariosDAO()
            return dao.findAll()
        }
    }

    fun save(usuarios: Usuarios): Response{
        val json = HttpHelper.post("$host/usuarios", usuarios.toJson())
        return parserJson(json)
    }

    fun saveOffline(usuarios: Usuarios): Boolean{
        val dao = DatabaseManager.getUsuariosDAO()

        if (! existeUsuarios(usuarios)){
            dao.insert(usuarios)
        }
        return true
    }

    fun existeUsuarios(usuarios: Usuarios):Boolean{
        val dao = DatabaseManager.getUsuariosDAO()
        return dao.getById(usuarios.id) != null
    }


    inline fun <reified T> parserJson(json: String) : T{
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

}