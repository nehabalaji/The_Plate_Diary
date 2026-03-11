package com.nbapps.theplatediary.core.data.repository

import com.nbapps.theplatediary.core.data.local.dao.MealLogDao
import com.nbapps.theplatediary.core.data.repository.mapper.toDomain
import com.nbapps.theplatediary.core.data.repository.mapper.toEntity
import com.nbapps.theplatediary.core.domain.model.MealLog
import com.nbapps.theplatediary.core.domain.model.MealLogItem
import com.nbapps.theplatediary.core.domain.repository.MealLogRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MealLogRepositoryImpl @Inject constructor(
    private val mealLogDao: MealLogDao,
) : MealLogRepository {
    override suspend fun upsertMealLog(mealLog: MealLog) = mealLogDao.upsertMealLog(mealLog.toEntity())

    override suspend fun upsertMealLogItems(items: List<MealLogItem>) =
        mealLogDao.upsertMealLogItems(items.map { it.toEntity() })

    override fun observeMealLogs(userId: String): Flow<List<MealLog>> =
        mealLogDao.observeMealLogs(userId).map { logs -> logs.map { it.toDomain() } }

    override fun observeMealLogItems(mealLogId: String): Flow<List<MealLogItem>> =
        mealLogDao.observeMealLogItems(mealLogId).map { items -> items.map { it.toDomain() } }
}
