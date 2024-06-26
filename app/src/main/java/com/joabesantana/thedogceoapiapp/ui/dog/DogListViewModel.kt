package com.joabesantana.thedogceoapiapp.ui.dog

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.joabesantana.retrofit_client.services.RetrofitClient
import com.joabesantana.thedogceoapiapp.model.Dog
import com.joabesantana.thedogceoapiapp.utils.ListUtil
import com.joabesantana.thedogceoapiapp.services.IDogService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogListViewModel : ViewModel() {

    private val baseUrl = "https://api.thedogapi.com"
    private var dogListLiveData = MutableLiveData<MutableList<Dog>>()

    fun fetchDogs(page: Int, limit: Int, concatResults: Boolean) {

        val service = RetrofitClient.createService(baseUrl, IDogService::class.java)

        val params: Map<String, String> = mapOf(
            "size" to "med",
            "mime_types" to "jpg",
            "format" to "json",
            "has_breeds" to "true",
            "order" to "RANDOM",
            "page" to page.toString(),
            "limit" to limit.toString()
        )

        val call = service.fetchDogs(params)

        call.enqueue(object : Callback<MutableList<Dog>> {

            override fun onResponse(
                call: Call<MutableList<Dog>>, response: Response<MutableList<Dog>>
            ) {
                if (response.isSuccessful) {
                    val dogsResults = response.body()
                    if (dogsResults != null) {
                        if (concatResults && dogListLiveData.value != null) {
                            dogListLiveData.value =
                                ListUtil.joinResults(dogListLiveData.value!!, dogsResults)
                        } else {
                            dogListLiveData.value = dogsResults
                        }
                    }
                } else {
                    println("Error to fetch Dog Images: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<MutableList<Dog>>, t: Throwable) {
                println("Error to fetch Dog Images: ${t.message}")
            }
        })
    }

    fun getDogListLiveData(): MutableLiveData<MutableList<Dog>> {
        return dogListLiveData
    }
}