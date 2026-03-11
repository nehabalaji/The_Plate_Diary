package com.nbapps.theplatediary.core.data.repository

import com.nbapps.theplatediary.core.data.local.dao.RecipeDao
import com.nbapps.theplatediary.core.data.repository.mapper.toDomain
import com.nbapps.theplatediary.core.data.repository.mapper.toEntity
import com.nbapps.theplatediary.core.domain.model.CuisineType
import com.nbapps.theplatediary.core.domain.model.Ingredient
import com.nbapps.theplatediary.core.domain.model.Recipe
import com.nbapps.theplatediary.core.domain.model.RecipeIngredient
import com.nbapps.theplatediary.core.domain.model.SavedRecipe
import com.nbapps.theplatediary.core.domain.repository.RecipeRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class RecipeRepositoryImpl @Inject constructor(
    private val recipeDao: RecipeDao,
) : RecipeRepository {
    override suspend fun upsertCuisine(cuisineType: CuisineType) = recipeDao.upsertCuisine(cuisineType.toEntity())

    override suspend fun upsertIngredient(ingredient: Ingredient) = recipeDao.upsertIngredient(ingredient.toEntity())

    override suspend fun upsertRecipe(recipe: Recipe) = recipeDao.upsertRecipe(recipe.toEntity())

    override suspend fun upsertRecipeIngredients(items: List<RecipeIngredient>) =
        recipeDao.upsertRecipeIngredients(items.map { it.toEntity() })

    override suspend fun upsertSavedRecipe(savedRecipe: SavedRecipe) =
        recipeDao.upsertSavedRecipe(savedRecipe.toEntity())

    override fun observeRecipes(): Flow<List<Recipe>> =
        recipeDao.observeRecipes().map { recipes -> recipes.map { it.toDomain() } }

    override fun observeRecipeIngredients(recipeId: String): Flow<List<RecipeIngredient>> =
        recipeDao.observeRecipeIngredients(recipeId).map { items -> items.map { it.toDomain() } }

    override fun observeSavedRecipes(userId: String): Flow<List<SavedRecipe>> =
        recipeDao.observeSavedRecipes(userId).map { items -> items.map { it.toDomain() } }
}
