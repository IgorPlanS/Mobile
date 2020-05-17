package com.impacta_zenith_app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Usuarios::class, TenhoInteresse:: class, FaleConosco:: class, Agendamento:: class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun UsuariosDAO() : UsuariosDAO
    abstract fun TenhoInteresseDAO() : TenhoInteresseDAO
    abstract fun FaleConoscoDAO() : FaleConoscoDAO
    abstract fun AgendamentoDAO() : AgendamentoDAO
}