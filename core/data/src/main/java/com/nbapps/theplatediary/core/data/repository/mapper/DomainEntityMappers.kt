package com.nbapps.theplatediary.core.data.repository.mapper

import com.nbapps.theplatediary.core.data.local.model.ActivityLevel as DataActivityLevel
import com.nbapps.theplatediary.core.data.local.model.AuthProvider as DataAuthProvider
import com.nbapps.theplatediary.core.data.local.model.CuisineTypeEntity
import com.nbapps.theplatediary.core.data.local.model.DietaryPreference as DataDietaryPreference
import com.nbapps.theplatediary.core.data.local.model.FoodItemEntity
import com.nbapps.theplatediary.core.data.local.model.FoodSource as DataFoodSource
import com.nbapps.theplatediary.core.data.local.model.GoalType as DataGoalType
import com.nbapps.theplatediary.core.data.local.model.IngredientEntity
import com.nbapps.theplatediary.core.data.local.model.MealLogEntity
import com.nbapps.theplatediary.core.data.local.model.MealLogItemEntity
import com.nbapps.theplatediary.core.data.local.model.MealType as DataMealType
import com.nbapps.theplatediary.core.data.local.model.NutritionDataEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeEntity
import com.nbapps.theplatediary.core.data.local.model.RecipeIngredientEntity
import com.nbapps.theplatediary.core.data.local.model.SavedRecipeEntity
import com.nbapps.theplatediary.core.data.local.model.Sex as DataSex
import com.nbapps.theplatediary.core.data.local.model.UserEntity
import com.nbapps.theplatediary.core.data.local.model.UserGoalEntity
import com.nbapps.theplatediary.core.data.local.model.UserProfileEntity
import com.nbapps.theplatediary.core.domain.model.ActivityLevel
import com.nbapps.theplatediary.core.domain.model.AuthProvider
import com.nbapps.theplatediary.core.domain.model.CuisineType
import com.nbapps.theplatediary.core.domain.model.DietaryPreference
import com.nbapps.theplatediary.core.domain.model.FoodItem
import com.nbapps.theplatediary.core.domain.model.FoodSource
import com.nbapps.theplatediary.core.domain.model.GoalType
import com.nbapps.theplatediary.core.domain.model.Ingredient
import com.nbapps.theplatediary.core.domain.model.MealLog
import com.nbapps.theplatediary.core.domain.model.MealLogItem
import com.nbapps.theplatediary.core.domain.model.MealType
import com.nbapps.theplatediary.core.domain.model.NutritionData
import com.nbapps.theplatediary.core.domain.model.Recipe
import com.nbapps.theplatediary.core.domain.model.RecipeIngredient
import com.nbapps.theplatediary.core.domain.model.SavedRecipe
import com.nbapps.theplatediary.core.domain.model.Sex
import com.nbapps.theplatediary.core.domain.model.User
import com.nbapps.theplatediary.core.domain.model.UserGoal
import com.nbapps.theplatediary.core.domain.model.UserProfile

fun UserEntity.toDomain(): User = User(id, email, displayName, AuthProvider.valueOf(authProvider.name))
fun User.toEntity(): UserEntity = UserEntity(id, email, displayName, DataAuthProvider.valueOf(authProvider.name))

fun UserProfileEntity.toDomain(): UserProfile = UserProfile(
    id = id,
    userId = userId,
    age = age,
    sex = Sex.valueOf(sex.name),
    heightCm = heightCm,
    weightKg = weightKg,
    activityLevel = ActivityLevel.valueOf(activityLevel.name),
    dietaryPreference = DietaryPreference.valueOf(dietaryPreference.name),
    allergies = allergies,
    goalType = GoalType.valueOf(goalType.name),
)

fun UserProfile.toEntity(): UserProfileEntity = UserProfileEntity(
    id = id,
    userId = userId,
    age = age,
    sex = DataSex.valueOf(sex.name),
    heightCm = heightCm,
    weightKg = weightKg,
    activityLevel = DataActivityLevel.valueOf(activityLevel.name),
    dietaryPreference = DataDietaryPreference.valueOf(dietaryPreference.name),
    allergies = allergies,
    goalType = DataGoalType.valueOf(goalType.name),
)

fun UserGoalEntity.toDomain(): UserGoal = UserGoal(
    id,
    userId,
    dailyCalories,
    proteinG,
    carbsG,
    fatG,
    isAiGenerated,
    aiRationale,
    effectiveDateEpochMillis,
    isActive,
)

fun UserGoal.toEntity(): UserGoalEntity = UserGoalEntity(
    id,
    userId,
    dailyCalories,
    proteinG,
    carbsG,
    fatG,
    isAiGenerated,
    aiRationale,
    effectiveDateEpochMillis,
    isActive,
)

fun FoodItemEntity.toDomain(): FoodItem = FoodItem(
    id,
    name,
    category,
    servingSize,
    servingGrams,
    barcode,
    FoodSource.valueOf(source.name),
)

fun FoodItem.toEntity(): FoodItemEntity = FoodItemEntity(
    id,
    name,
    category,
    servingSize,
    servingGrams,
    barcode,
    DataFoodSource.valueOf(source.name),
)

fun NutritionDataEntity.toDomain(): NutritionData = NutritionData(
    id,
    foodItemId,
    calories,
    proteinG,
    carbsG,
    fatG,
    fiberG,
    sodiumMg,
    ironMg,
    vitaminAMcg,
    vitaminCMg,
    vitaminDMcg,
    calciumMg,
    potassiumMg,
    isAiEstimated,
)

fun NutritionData.toEntity(): NutritionDataEntity = NutritionDataEntity(
    id,
    foodItemId,
    calories,
    proteinG,
    carbsG,
    fatG,
    fiberG,
    sodiumMg,
    ironMg,
    vitaminAMcg,
    vitaminCMg,
    vitaminDMcg,
    calciumMg,
    potassiumMg,
    isAiEstimated,
)

fun MealLogEntity.toDomain(): MealLog = MealLog(
    id,
    userId,
    MealType.valueOf(mealType.name),
    loggedAtEpochMillis,
    totalCalories,
)

fun MealLog.toEntity(): MealLogEntity = MealLogEntity(
    id,
    userId,
    DataMealType.valueOf(mealType.name),
    loggedAtEpochMillis,
    totalCalories,
)

fun MealLogItemEntity.toDomain(): MealLogItem = MealLogItem(
    id,
    mealLogId,
    foodItemId,
    servings,
    customGrams,
)

fun MealLogItem.toEntity(): MealLogItemEntity = MealLogItemEntity(
    id,
    mealLogId,
    foodItemId,
    servings,
    customGrams,
)

fun CuisineTypeEntity.toDomain(): CuisineType = CuisineType(id, name)
fun CuisineType.toEntity(): CuisineTypeEntity = CuisineTypeEntity(id, name)

fun IngredientEntity.toDomain(): Ingredient = Ingredient(id, name, category)
fun Ingredient.toEntity(): IngredientEntity = IngredientEntity(id, name, category)

fun RecipeEntity.toDomain(): Recipe = Recipe(
    id,
    cuisineId,
    title,
    instructions,
    prepTimeMinutes,
    cookTimeMinutes,
    servings,
    perServingCalories,
    perServingProteinG,
    perServingCarbsG,
    perServingFatG,
    generatedByAi,
)

fun Recipe.toEntity(): RecipeEntity = RecipeEntity(
    id,
    cuisineId,
    title,
    instructions,
    prepTimeMinutes,
    cookTimeMinutes,
    servings,
    perServingCalories,
    perServingProteinG,
    perServingCarbsG,
    perServingFatG,
    generatedByAi,
)

fun RecipeIngredientEntity.toDomain(): RecipeIngredient = RecipeIngredient(
    id,
    recipeId,
    ingredientId,
    quantity,
    isOptional,
)

fun RecipeIngredient.toEntity(): RecipeIngredientEntity = RecipeIngredientEntity(
    id,
    recipeId,
    ingredientId,
    quantity,
    isOptional,
)

fun SavedRecipeEntity.toDomain(): SavedRecipe = SavedRecipe(id, userId, recipeId, savedAtEpochMillis)
fun SavedRecipe.toEntity(): SavedRecipeEntity = SavedRecipeEntity(id, userId, recipeId, savedAtEpochMillis)
