package com.healthypalate.food_e_s.data

import com.healthypalate.food_e_s.model.Category

interface FoodEsRepository {

    fun getCategories(): List<Category>
    fun getObject(): String
}