package com.nbapps.theplatediary.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbapps.theplatediary.core.data.local.model.UserGoalEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface GoalDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertGoal(goal: UserGoalEntity)

    @Query("SELECT * FROM user_goals WHERE user_id = :userId ORDER BY effective_date DESC")
    fun observeGoals(userId: String): Flow<List<UserGoalEntity>>

    @Query("SELECT * FROM user_goals WHERE user_id = :userId AND is_active = 1 LIMIT 1")
    fun observeActiveGoal(userId: String): Flow<UserGoalEntity?>
}
