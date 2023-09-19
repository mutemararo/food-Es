package com.healthypalate.food_e_s.util

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable

sealed class RawResource {
    class JSONResource(
        @RawRes resId: Int
    ): RawResource()

    @Composable
    fun getJson(){
    }

}