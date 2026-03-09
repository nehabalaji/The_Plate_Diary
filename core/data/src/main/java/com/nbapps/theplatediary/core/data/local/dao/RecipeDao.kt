package com.nbapps.theplatediary.core.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nbapps.theplatediary.core.data.local.model.CuisineTypeEntity
import com.nbapps.theplatediary.core.data.local.model.IngredientEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeIngredientEntity
import com.nbapps.theplatediary.core.data.local.model.SavedRecipeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RecipeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertCuisine(cuisineType: CuisineTypeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertIngredient(ingredient: IngredientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRecipe(recipe: RecipeEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertRecipeIngredients(items: List<RecipeIngredientEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSavedRecipe(savedRecipe: SavedRecipeEntity)

    @Query("SELECT * FROM recipes ORDER BY title ASC")
    fun observeRecipes(): Flow<List<RecipeEntity>>

    @Query("SELECT * FROM recipe_ingredients WHERE recipe_id = :recipeId")
    fun observeRecipeIngredients(recipeId: String): Flow<List<RecipeIngredientEntity>>

    @Query("SELECT * FROM saved_recipes WHERE user_id = :userId ORDER BY saved_at DESC")
    fun observeSavedRecipes(userId: String): Flow<List<SavedRecipeEntity>>
}
