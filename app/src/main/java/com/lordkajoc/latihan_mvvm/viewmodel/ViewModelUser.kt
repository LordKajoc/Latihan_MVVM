package com.lordkajoc.latihan_mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lordkajoc.latihan_mvvm.model.GetUserItemItem
import com.lordkajoc.latihan_mvvm.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModelUser: ViewModel() {
    var liveDataList = MutableLiveData<List<GetUserItemItem>?>()

    fun getliveDataUser(): MutableLiveData<List<GetUserItemItem>?> {
        return  liveDataList
    }

//    fun getliveDataUser(): MutableLiveData<List<UserResponseItem>> {
//        return  liveDataList
//    }

    fun getDataUser(){
        ApiClient.instance.getAllUser()
            .enqueue(object : Callback<List<GetUserItemItem>>{
                override fun onResponse(
                    call: Call<List<GetUserItemItem>>,
                    response: Response<List<GetUserItemItem>>
                ) {
                    if (response.isSuccessful){
                        liveDataList.postValue(response.body())
                    }else{
                        liveDataList.postValue(null)
                    }
                }

                override fun onFailure(call: Call<List<GetUserItemItem>>, t: Throwable) {
                    liveDataList.postValue(null)
                }

            })
    }
}