package com.nbapps.theplatediary.core.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.nbapps.theplatediary.core.data.local.dao.FoodDao
import com.nbapps.theplatediary.core.data.local.dao.GoalDao
import com.nbapps.theplatediary.core.data.local.dao.MealLogDao
import com.nbapps.theplatediary.core.data.local.dao.RecipeDao
import com.nbapps.theplatediary.core.data.local.dao.UserDao
import com.nbapps.theplatediary.core.data.local.model.CuisineTypeEntity
import com.nbapps.theplatediary.core.data.local.model.FoodItemEntity
import com.nbapps.theplatediary.core.data.local.model.IngredientEntity
import com.nbapps.theplatediary.core.data.local.model.MealLogEntity
import com.nbapps.theplatediary.core.data.local.model.MealLogItemEntity
import com.nbapps.theplatediary.core.data.local.model.NutritionDataEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeIngredientEntity
import com.nbapps.theplatediary.core.data.local.model.RoomConverters
import com.nbapps.theplatediary.core.data.local.model.SavedRecipeEntity
import com.nbapps.theplatediary.core.data.local.model.UserEntity
import com.nbapps.theplatediary.core.data.local.model.UserGoalEntity
import com.nbapps.theplatediary.core.data.local.model.UserProfileEntity

@Database(
    entities = [
        UserEntity::class,
        UserProfileEntity::class,
        UserGoalEntity::class,
        FoodItemEntity::class,
        NutritionDataEntity::class,
        MealLogEntity::class,
        MealLogItemEntity::class,
        IngredientEntity::class,
        CuisineTypeEntity::class,
        RecipeEntity::class,
        RecipeIngredientEntity::class,
        SavedRecipeEntity::class,
    ],
    version = 1,
    exportSchema = true,
)
@TypeConverters(RoomConverters::class)
abstract class ThePlateDiaryDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun goalDao(): GoalDao
    abstract fun foodDao(): FoodDao
    abstract fun mealLogDao(): MealLogDao
    abstract fun recipeDao(): RecipeDao
}
