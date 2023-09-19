package com.healthypalate.food_e_s

import android.app.Application
import android.content.Context
import com.healthypalate.food_e_s.data.ApplicationContainer
import com.healthypalate.food_e_s.data.DefaultContainer

class FoodEsApplication : Application(){

    val container: ApplicationContainer by lazy {
        DefaultContainer(applicationContext)
    }

}