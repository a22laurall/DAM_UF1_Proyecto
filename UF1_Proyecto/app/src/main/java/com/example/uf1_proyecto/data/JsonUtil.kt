package com.example.uf1_proyecto.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonUtil {
    inline fun <reified T> leerJsonDesdeRaw(context: Context, nombreArchivo: Int): List<T> {
        val inputStream = context.resources.openRawResource(nombreArchivo)
        val json = inputStream.bufferedReader().use { it.readText() }
        val tipoLista = object : TypeToken<List<T>>() {}.type
        return Gson().fromJson(json, tipoLista)
    }
}
