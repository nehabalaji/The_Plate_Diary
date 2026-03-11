package com.nbapps.theplatediary.core.domain.repository

import com.nbapps.theplatediary.core.domain.model.CuisineType
import com.nbapps.theplatediary.core.domain.model.FoodItem
import com.nbapps.theplatediary.core.domain.model.Ingredient
import com.nbapps.theplatediary.core.domain.model.MealLog
import com.nbapps.theplatediary.core.domain.model.MealLogItem
import com.nbapps.theplatediary.core.domain.model.NutritionData
import com.nbapps.theplatediary.core.domain.model.Recipe
import com.nbapps.theplatediary.core.domain.model.RecipeIngredient
import com.nbapps.theplatediary.core.domain.model.SavedRecipe
import com.nbapps.theplatediary.core.domain.model.User
import com.nbapps.theplatediary.core.domain.model.UserGoal
import com.nbapps.theplatediary.core.domain.model.UserProfile
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun upsertUser(user: User)
    suspend fun upsertProfile(profile: UserProfile)
    fun observeUser(userId: String): Flow<User?>
    fun observeProfile(userId: String): Flow<UserProfile?>
}

interface GoalRepository {
    suspend fun upsertGoal(goal: UserGoal)
    fun observeGoals(userId: String): Flow<List<UserGoal>>
    fun observeActiveGoal(userId: String): Flow<UserGoal?>
}

interface FoodRepository {
    suspend fun upsertFoodItem(foodItem: FoodItem)
    suspend fun upsertNutrition(nutritionData: NutritionData)
    fun observeFoodSearch(query: String): Flow<List<FoodItem>>
    fun observeNutrition(foodItemId: String): Flow<NutritionData?>
}

interface MealLogRepository {
    suspend fun upsertMealLog(mealLog: MealLog)
    suspend fun upsertMealLogItems(items: List<MealLogItem>)
    fun observeMealLogs(userId: String): Flow<List<MealLog>>
    fun observeMealLogItems(mealLogId: String): Flow<List<MealLogItem>>
}

interface RecipeRepository {
    suspend fun upsertCuisine(cuisineType: CuisineType)
    suspend fun upsertIngredient(ingredient: Ingredient)
    suspend fun upsertRecipe(recipe: Recipe)
    suspend fun upsertRecipeIngredients(items: List<RecipeIngredient>)
    suspend fun upsertSavedRecipe(savedRecipe: SavedRecipe)
    fun observeRecipes(): Flow<List<Recipe>>
    fun observeRecipeIngredients(recipeId: String): Flow<List<RecipeIngredient>>
    fun observeSavedRecipes(userId: String): Flow<List<SavedRecipe>>
}
