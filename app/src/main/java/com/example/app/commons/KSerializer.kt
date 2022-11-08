package com.example.app.commons

import com.google.gson.Gson

interface KSerializer {
    fun <T> fromJson(json: String?, classObj: Class<T>): T
    fun <T> toJson(obj: T, classObj: Class<T>): String
}

class GsonJSerializer : KSerializer {

    private val gson = Gson()

    override fun <T> fromJson(json: String?, classObj: Class<T>): T {
        return gson.fromJson(json, classObj)
    }

    override fun <T> toJson(obj: T, classObj: Class<T>): String {
        return gson.toJson(obj, classObj)
    }
}