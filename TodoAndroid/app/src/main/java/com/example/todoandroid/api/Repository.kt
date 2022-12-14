package com.example.todoandroid.api

import com.example.todoandroid.model.Categoria
import retrofit2.Response

class Repository<T> {

    suspend fun listCategoria(): Response<List<Categoria>> {
        return RetrofitInstance.api.listCategoria()
    }

}