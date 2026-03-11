package com.nbapps.theplatediary.core.data.repository

import com.nbapps.theplatediary.core.data.local.dao.FoodDao
import com.nbapps.theplatediary.core.data.repository.mapper.toDomain
import com.nbapps.theplatediary.core.data.repository.mapper.toEntity
import com.nbapps.theplatediary.core.domain.model.FoodItem
import com.nbapps.theplatediary.core.domain.model.NutritionData
import com.nbapps.theplatediary.core.domain.repository.FoodRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FoodRepositoryImpl @Inject constructor(
    private val foodDao: FoodDao,
) : FoodRepository {
    override suspend fun upsertFoodItem(foodItem: FoodItem) = foodDao.upsertFoodItem(foodItem.toEntity())

    override suspend fun upsertNutrition(nutritionData: NutritionData) =
        foodDao.upsertNutrition(nutritionData.toEntity())

    override fun observeFoodSearch(query: String): Flow<List<FoodItem>> =
        foodDao.observeFoodSearch(query).map { items -> items.map { it.toDomain() } }

    override fun observeNutrition(foodItemId: String): Flow<NutritionData?> =
        foodDao.observeNutrition(foodItemId).map { it?.toDomain() }
}
