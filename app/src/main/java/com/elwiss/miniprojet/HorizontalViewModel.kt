package com.elwiss.miniprojet

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.elwiss.miniprojet.api.RestInterface
import com.elwiss.miniprojet.api.RetrofitInstance2
import com.elwiss.miniprojet.models.UnsplashPhoto
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HorizontalViewModel : ViewModel() {
    //this is the data that we will fetch asynchronously
    private var unsplashPhotoList: MutableLiveData<List<UnsplashPhoto>>? = null
    val errorMessage = MutableLiveData<String>()

    //we will call this method to get the data
    fun getHeroes(): MutableLiveData<List<UnsplashPhoto>>? {
        //if the list is null
        if (unsplashPhotoList == null) {
            unsplashPhotoList = MutableLiveData<List<UnsplashPhoto>>()
            //we will load it asynchronously from server in this method
            loadHeroes()
        }
        //finally we will return the list

        return unsplashPhotoList
    }

    //This method is using Retrofit to get the JSON data from URL
    private fun loadHeroes() {
        val retIn =
            RetrofitInstance2.getRetrofitInstance2().create(
                RestInterface::class.java
            )
        val response = retIn.getHeroes()
        response.enqueue(object : Callback<List<UnsplashPhoto>> {
            override fun onResponse(
                call: Call<List<UnsplashPhoto>>, response:
                Response<List<UnsplashPhoto>>
            ) {
                unsplashPhotoList?.postValue(response.body())
            }

            override fun onFailure(call: Call<List<UnsplashPhoto>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }
}
