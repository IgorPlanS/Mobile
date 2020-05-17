package com.impacta_zenith_app

import androidx.room.Room

object DatabaseManager {

    private var dbInstance: LMSDatabase

    init {
        val appContext = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            appContext,
            LMSDatabase::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getUsuariosDAO(): UsuariosDAO{
        return dbInstance.UsuariosDAO()
    }

    fun getTenhoInteresseDAO(): TenhoInteresseDAO{
        return dbInstance.TenhoInteresseDAO()
    }

    fun getFaleConoscoDAO(): FaleConoscoDAO{
        return dbInstance.FaleConoscoDAO()
    }

    fun getAgendamentoDAO(): AgendamentoDAO{
        return dbInstance.AgendamentoDAO()
    }

}