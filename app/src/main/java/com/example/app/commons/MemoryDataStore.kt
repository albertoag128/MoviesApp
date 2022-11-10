package com.example.app.commons

class MemoryDataStore<T> {
    private val dataStore: MutableMap<String, T> = mutableMapOf()

    fun put(id: String, model: T) {
        dataStore.put(id, model)
    }

    fun getById(id: String) = dataStore[id]

    fun getAll():List<T>{
        var list = mutableListOf<T>()
        dataStore.forEach {
            list.add(it.value)
        }
        return list
    }
}