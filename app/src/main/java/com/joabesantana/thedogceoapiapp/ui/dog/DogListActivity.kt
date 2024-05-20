package com.joabesantana.thedogceoapiapp.ui.dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.joabesantana.thedogceoapiapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogListBinding
    private lateinit var dogViewModel: DogListViewModel
    private lateinit var gridView: GridView
    private lateinit var dogAdapter: DogAdapter

    private var page: Int = 0
    private var dogImagesLimit: Int = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridView = binding.idGridViewPhotos

        dogAdapter = DogAdapter(this)
        gridView.adapter = dogAdapter

        dogViewModel = ViewModelProvider(this)[DogListViewModel::class.java]
        dogViewModel.fetchDogs(++page, dogImagesLimit, false)

        dogViewModel.getDogListLiveData().observe(this) { dogsList ->
            dogAdapter.setDogList(dogsList)
            if (dogsList.size > dogImagesLimit) {
                Toast.makeText(this, "$dogImagesLimit more results below", Toast.LENGTH_SHORT)
                    .show()
            }
        }

        binding.btLoadMore.setOnClickListener {
            dogViewModel.fetchDogs(++page, dogImagesLimit, true)
        }
    }
}