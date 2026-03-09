package com.nbapps.theplatediary.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbapps.theplatediary.core.data.local.model.FoodItemEntity
import com.nbapps.theplatediary.core.data.local.model.NutritionDataEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertFoodItem(foodItem: FoodItemEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNutrition(nutritionData: NutritionDataEntity)

    @Query("SELECT * FROM food_items WHERE name LIKE '%' || :query || '%' ORDER BY name ASC")
    fun observeFoodSearch(query: String): Flow<List<FoodItemEntity>>

    @Query("SELECT * FROM nutrition_data WHERE food_item_id = :foodItemId LIMIT 1")
    fun observeNutrition(foodItemId: String): Flow<NutritionDataEntity?>
}
