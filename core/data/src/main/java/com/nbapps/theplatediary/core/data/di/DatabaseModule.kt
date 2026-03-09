package com.nbapps.theplatediary.core.data.di

import android.content.Context
import androidx.room.Room
import com.nbapps.theplatediary.core.data.local.dao.FoodDao
import com.nbapps.theplatediary.core.data.local.dao.GoalDao
import com.nbapps.theplatediary.core.data.local.dao.MealLogDao
import com.nbapps.theplatediary.core.data.local.dao.RecipeDao
import com.nbapps.theplatediary.core.data.local.dao.UserDao
import com.nbapps.theplatediary.core.data.local.db.ThePlateDiaryDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context,
    ): ThePlateDiaryDatabase =
        Room.databaseBuilder(
            context,
            ThePlateDiaryDatabase::class.java,
            "the_plate_diary.db",
        ).fallbackToDestructiveMigration(dropAllTables = true).build()

    @Provides
    fun provideUserDao(database: ThePlateDiaryDatabase): UserDao = database.userDao()

    @Provides
    fun provideGoalDao(database: ThePlateDiaryDatabase): GoalDao = database.goalDao()

    @Provides
    fun provideFoodDao(database: ThePlateDiaryDatabase): FoodDao = database.foodDao()

    @Provides
    fun provideMealLogDao(database: ThePlateDiaryDatabase): MealLogDao = database.mealLogDao()

    @Provides
    fun provideRecipeDao(database: ThePlateDiaryDatabase): RecipeDao = database.recipeDao()
}
