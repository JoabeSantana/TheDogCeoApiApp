package com.joabesantana.thedogceoapiapp.ui.dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.GridView
import androidx.lifecycle.ViewModelProvider
import com.joabesantana.thedogceoapiapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogListBinding
    private lateinit var dogViewModel: DogListViewModel
    private lateinit var gridView: GridView
    private lateinit var dogAdapter: DogAdapter

    private var page: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gridView = binding.idGridViewPhotos

        dogViewModel = ViewModelProvider(this)[DogListViewModel::class.java]

        dogViewModel.fetchDogs(++page, false)

        dogViewModel.getDogListLiveData().observe(this) { dogsList ->
            if (dogsList != null) {
                dogAdapter = DogAdapter(this, dogsList)
                gridView.adapter = dogAdapter
                dogAdapter.notifyDataSetChanged()
                if (page > 1) {
                    gridView.setSelection(dogsList.size)
                }
            }
        }

        binding.btLoadMore.setOnClickListener {
            dogViewModel.fetchDogs(++page,true)
        }
    }
}