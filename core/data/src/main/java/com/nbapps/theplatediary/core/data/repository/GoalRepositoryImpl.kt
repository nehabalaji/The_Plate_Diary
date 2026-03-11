package com.nbapps.theplatediary.core.data.repository

import com.nbapps.theplatediary.core.data.local.dao.GoalDao
import com.nbapps.theplatediary.core.data.repository.mapper.toDomain
import com.nbapps.theplatediary.core.data.repository.mapper.toEntity
import com.nbapps.theplatediary.core.domain.model.UserGoal
import com.nbapps.theplatediary.core.domain.repository.GoalRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GoalRepositoryImpl @Inject constructor(
    private val goalDao: GoalDao,
) : GoalRepository {
    override suspend fun upsertGoal(goal: UserGoal) = goalDao.upsertGoal(goal.toEntity())

    override fun observeGoals(userId: String): Flow<List<UserGoal>> =
        goalDao.observeGoals(userId).map { goals -> goals.map { it.toDomain() } }

    override fun observeActiveGoal(userId: String): Flow<UserGoal?> =
        goalDao.observeActiveGoal(userId).map { it?.toDomain() }
}
