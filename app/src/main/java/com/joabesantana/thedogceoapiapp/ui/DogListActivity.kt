package com.joabesantana.thedogceoapiapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.joabesantana.thedogceoapiapp.R
import com.joabesantana.thedogceoapiapp.databinding.ActivityDogListBinding

class DogListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDogListBinding.inflate(layoutInflater)
        setContentView(binding.root)


    }
}