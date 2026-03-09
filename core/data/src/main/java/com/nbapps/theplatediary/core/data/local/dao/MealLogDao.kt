package com.nbapps.theplatediary.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbapps.theplatediary.core.data.local.model.MealLogEntity
import com.nbapps.theplatediary.core.data.local.model.MealLogItemEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MealLogDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMealLog(mealLog: MealLogEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMealLogItems(items: List<MealLogItemEntity>)

    @Query("SELECT * FROM meal_logs WHERE user_id = :userId ORDER BY logged_at DESC")
    fun observeMealLogs(userId: String): Flow<List<MealLogEntity>>

    @Query("SELECT * FROM meal_log_items WHERE meal_log_id = :mealLogId")
    fun observeMealLogItems(mealLogId: String): Flow<List<MealLogItemEntity>>
}
