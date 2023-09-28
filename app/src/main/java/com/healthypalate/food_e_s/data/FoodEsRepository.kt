package com.healthypalate.food_e_s.data

import com.healthypalate.food_e_s.model.Additive
import com.healthypalate.food_e_s.model.Category

interface FoodEsRepository {

    fun getObject(): String
    fun getCategoryItems(categoryIndex: Int): MutableList<Additive>
    fun getItem(code: String): Additive

    fun getAllAdditives(): MutableList<Additive>
}