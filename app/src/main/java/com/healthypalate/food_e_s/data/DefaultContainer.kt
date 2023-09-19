package com.healthypalate.food_e_s.data

import android.app.Application
import android.content.Context
import android.content.res.Resources
import com.healthypalate.food_e_s.FoodEsApplication
import com.healthypalate.food_e_s.R
import org.json.JSONObject

class DefaultContainer(context: Context): ApplicationContainer{

    private val aRawJSON = context.resources.openRawResource(
        R.raw.food_additives
    )
        .bufferedReader().use { it.readText() }

    override val repository: FoodEsRepository by lazy{
        JSONRepository(JSONObject(aRawJSON))
    }

}