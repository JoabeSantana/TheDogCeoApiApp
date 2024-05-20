package com.joabesantana.thedogceoapiapp.ui.dog

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.joabesantana.thedogceoapiapp.R
import com.joabesantana.thedogceoapiapp.databinding.ItemDogBinding
import com.joabesantana.thedogceoapiapp.model.Dog

class DogAdapter(context: Context) : ArrayAdapter<Dog?>(context, 0) {

    private var dogList = ArrayList<Dog>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var itemListView = convertView
        if (itemListView == null) {
            itemListView = ItemDogBinding.inflate(LayoutInflater.from(parent.context)).root
        }

        val dog: Dog = dogList[position]

        val breedTextView: TextView = itemListView.findViewById(R.id.breedTextView)
        val imageView: ImageView = itemListView.findViewById(R.id.imgDogView)

        breedTextView.text = dog.breeds.first().name
        Glide.with(itemListView).load(dog.url).centerCrop().into(imageView)

        imageView.setOnClickListener { view ->
            val intent = Intent(parent.context, DogDetailActivity::class.java)
            intent.putExtra("dog", dog)
            view.context.startActivity(intent)
        }

        return itemListView
    }

    override fun getCount(): Int {
        return dogList.size
    }

    fun setDogList(dogList: List<Dog>) {
        this.dogList = dogList as ArrayList<Dog>
        notifyDataSetChanged()
    }
}