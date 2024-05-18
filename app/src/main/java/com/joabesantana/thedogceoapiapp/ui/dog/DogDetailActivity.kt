package com.joabesantana.thedogceoapiapp.ui.dog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.joabesantana.thedogceoapiapp.databinding.ActivityDogDetailBinding
import com.joabesantana.thedogceoapiapp.model.Dog

class DogDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDogDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDogDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dog = intent.getSerializableExtra("dog") as? Dog

        title = dog!!.breeds.first().name

        binding.height.text = dog.breeds.first().height.metric
        binding.wight.text = dog.breeds.first().weight.metric
        binding.lifeSpan.text = dog.breeds.first().lifeSpan
        binding.breedGroup.text = dog.breeds.first().breedGroup
        binding.temperament.text = "A dog of a temperament ${dog.breeds.first().temperament}."
        binding.breedFor.text = "A breed for ${dog.breeds.first().bredFor}."

        Glide.with(this).load(dog.url).fitCenter().into(binding.imageDogView)
    }
}