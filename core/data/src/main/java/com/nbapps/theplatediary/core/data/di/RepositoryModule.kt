package com.nbapps.theplatediary.core.data.di

import com.nbapps.theplatediary.core.data.repository.FoodRepositoryImpl
import com.nbapps.theplatediary.core.data.repository.GoalRepositoryImpl
import com.nbapps.theplatediary.core.data.repository.MealLogRepositoryImpl
import com.nbapps.theplatediary.core.data.repository.RecipeRepositoryImpl
import com.nbapps.theplatediary.core.data.repository.UserRepositoryImpl
import com.nbapps.theplatediary.core.domain.repository.FoodRepository
import com.nbapps.theplatediary.core.domain.repository.GoalRepository
import com.nbapps.theplatediary.core.domain.repository.MealLogRepository
import com.nbapps.theplatediary.core.domain.repository.RecipeRepository
import com.nbapps.theplatediary.core.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    @Binds
    @Singleton
    abstract fun bindGoalRepository(impl: GoalRepositoryImpl): GoalRepository

    @Binds
    @Singleton
    abstract fun bindFoodRepository(impl: FoodRepositoryImpl): FoodRepository

    @Binds
    @Singleton
    abstract fun bindMealLogRepository(impl: MealLogRepositoryImpl): MealLogRepository

    @Binds
    @Singleton
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository
}
