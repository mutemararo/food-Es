package com.healthypalate.food_e_s.data

import android.content.Context
import android.content.res.Resources
import android.util.JsonReader
import com.healthypalate.food_e_s.R
import com.healthypalate.food_e_s.model.Category
import org.json.JSONObject
import java.io.BufferedReader
import java.io.FileReader

class JSONRepository(private val foods: JSONObject?): FoodEsRepository{

    override fun getCategories(): List<Category> {
        TODO("do something here")
    }

    override fun getObject():String{
        return foods.toString()
    }


}