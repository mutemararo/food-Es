package com.healthypalate.food_e_s.data

import com.healthypalate.food_e_s.model.Category
import org.json.JSONObject

class JSONRepository: FoodEsRepository {
    private val anObject : JSONObject = JSONObject()
    override fun getCategories(): List<Category> {
        TODO("Not yet implemented")
    }
}