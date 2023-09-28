package com.healthypalate.food_e_s.data

import com.healthypalate.food_e_s.model.Additive
import org.json.JSONArray
import org.json.JSONObject

class JSONRepository(private val foods: JSONObject?): FoodEsRepository{

    override fun getObject():String{
        return foods.toString()
    }

    override fun getCategoryItems(categoryIndex: Int): MutableList<Additive> {
        val additives = foods?.getJSONArray("additives")
        val category = additives?.get(categoryIndex) as JSONArray
        val allColors = mutableListOf<Additive>()

        for(i in 0 until category.length()){
            val additive = Additive()
            additive.id = category.getJSONObject(i).getInt("id")
            additive.code = category.getJSONObject(i).getString("code")
            additive.name = category.getJSONObject(i).getString("name")
            additive.function = category.getJSONObject(i).getString("function")
            additive.warnings = category.getJSONObject(i).getString("warnings")
            additive.status = category.getJSONObject(i).getString("status")
            additive.foods = category.getJSONObject(i).getString("foods")
            additive.details = category.getJSONObject(i).getString("details")
            allColors.add(additive)
        }
        return allColors
    }

    override fun getItem(code: String): Additive {
        TODO()
    }

    override fun getAllAdditives(): MutableList<Additive> {
        val additivesCategoriesSize = foods?.getJSONArray("additives")!!.length()
        val allAdditives = mutableListOf<Additive>()
        for (i in 0 until additivesCategoriesSize){
            allAdditives.addAll(getCategoryItems(i))
        }
        return allAdditives
    }
}