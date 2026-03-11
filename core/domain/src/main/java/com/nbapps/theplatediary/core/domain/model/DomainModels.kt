package com.nbapps.theplatediary.core.domain.model

enum class AuthProvider {
    GOOGLE,
    EMAIL,
}

enum class Sex {
    FEMALE,
    MALE,
    OTHER,
}

enum class ActivityLevel {
    SEDENTARY,
    LIGHT,
    MODERATE,
    ACTIVE,
    VERY_ACTIVE,
}

enum class DietaryPreference {
    NONE,
    VEGETARIAN,
    VEGAN,
    PESCATARIAN,
    KETO,
    PALEO,
    GLUTEN_FREE,
}

enum class GoalType {
    LOSE_WEIGHT,
    MAINTAIN_WEIGHT,
    GAIN_WEIGHT,
    BUILD_MUSCLE,
}

enum class FoodSource {
    USDA,
    AI,
    USER,
}

enum class MealType {
    BREAKFAST,
    LUNCH,
    DINNER,
    SNACK,
}

data class User(
    val id: String,
    val email: String,
    val displayName: String,
    val authProvider: AuthProvider,
)

data class UserProfile(
    val id: String,
    val userId: String,
    val age: Int,
    val sex: Sex,
    val heightCm: Float,
    val weightKg: Float,
    val activityLevel: ActivityLevel,
    val dietaryPreference: DietaryPreference,
    val allergies: String?,
    val goalType: GoalType,
)

data class UserGoal(
    val id: String,
    val userId: String,
    val dailyCalories: Int,
    val proteinG: Float,
    val carbsG: Float,
    val fatG: Float,
    val isAiGenerated: Boolean,
    val aiRationale: String?,
    val effectiveDateEpochMillis: Long,
    val isActive: Boolean,
)

data class FoodItem(
    val id: String,
    val name: String,
    val category: String,
    val servingSize: String,
    val servingGrams: Float,
    val barcode: String?,
    val source: FoodSource,
)

data class NutritionData(
    val id: String,
    val foodItemId: String,
    val calories: Int,
    val proteinG: Float,
    val carbsG: Float,
    val fatG: Float,
    val fiberG: Float,
    val sodiumMg: Float,
    val ironMg: Float,
    val vitaminAMcg: Float?,
    val vitaminCMg: Float?,
    val vitaminDMcg: Float?,
    val calciumMg: Float,
    val potassiumMg: Float,
    val isAiEstimated: Boolean,
)

data class MealLog(
    val id: String,
    val userId: String,
    val mealType: MealType,
    val loggedAtEpochMillis: Long,
    val totalCalories: Int,
)

data class MealLogItem(
    val id: String,
    val mealLogId: String,
    val foodItemId: String,
    val servings: Float,
    val customGrams: Float?,
)

data class Ingredient(
    val id: String,
    val name: String,
    val category: String,
)

data class CuisineType(
    val id: String,
    val name: String,
)

data class Recipe(
    val id: String,
    val cuisineId: String,
    val title: String,
    val instructions: String,
    val prepTimeMinutes: Int,
    val cookTimeMinutes: Int,
    val servings: Int,
    val perServingCalories: Int,
    val perServingProteinG: Float,
    val perServingCarbsG: Float,
    val perServingFatG: Float,
    val generatedByAi: Boolean,
)

data class RecipeIngredient(
    val id: String,
    val recipeId: String,
    val ingredientId: String,
    val quantity: String,
    val isOptional: Boolean,
)

data class SavedRecipe(
    val id: String,
    val userId: String,
    val recipeId: String,
    val savedAtEpochMillis: Long,
)
