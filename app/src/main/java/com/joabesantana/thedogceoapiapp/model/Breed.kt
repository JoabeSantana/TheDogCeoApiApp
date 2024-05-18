package com.joabesantana.thedogceoapiapp.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Breed(

    @SerializedName("weight")
    val weight: Weight,

    @SerializedName("height")
    val height: Height,

    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("bred_for")
    val bredFor: String,

    @SerializedName("breed_group")
    val breedGroup: String,

    @SerializedName("life_span")
    val lifeSpan: String,

    @SerializedName("temperament")
    val temperament: String,

    @SerializedName("reference_image_id")
    val referenceImageId: String,
) : Serializable