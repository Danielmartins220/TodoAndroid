package com.example.todoandroid

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoandroid.api.Repository
import com.example.todoandroid.model.Categoria
import kotlinx.coroutines.launch
import okhttp3.Response

class MainViewModel(
    private val repository: Repository
) : ViewModel(){




    private val _myCategoriaRespose =
        MutableLiveData<Response<List<Categoria>>>()

        val myCategoriaResponse: LiveData<Response<List<Categoria>> =
            _myCategoriaRespose

        init {
            listCategoria()
        }

        fun listCategoria(){
            viewModelScope.launch {
                try{

                    val response = respository.listCategoria()
                    _myCategoriaRespose.value = response

                }catch (e: Exception){
                    Log.d("Erro", e.message.toString())
                }
            }
        }
}


