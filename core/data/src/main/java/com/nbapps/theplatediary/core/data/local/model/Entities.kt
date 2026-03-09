package com.nbapps.theplatediary.core.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val email: String,
    @ColumnInfo(name = "display_name")
    val displayName: String,
    @ColumnInfo(name = "auth_provider")
    val authProvider: AuthProvider,
)

@Entity(
    tableName = "user_profiles",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["user_id"], unique = true),
    ],
)
data class UserProfileEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    val userId: String,
    val age: Int,
    val sex: Sex,
    @ColumnInfo(name = "height_cm")
    val heightCm: Float,
    @ColumnInfo(name = "weight_kg")
    val weightKg: Float,
    @ColumnInfo(name = "activity_level")
    val activityLevel: ActivityLevel,
    @ColumnInfo(name = "dietary_preference")
    val dietaryPreference: DietaryPreference,
    val allergies: String?,
    @ColumnInfo(name = "goal_type")
    val goalType: GoalType,
)

@Entity(
    tableName = "user_goals",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["user_id"]),
    ],
)
data class UserGoalEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "daily_calories")
    val dailyCalories: Int,
    @ColumnInfo(name = "protein_g")
    val proteinG: Float,
    @ColumnInfo(name = "carbs_g")
    val carbsG: Float,
    @ColumnInfo(name = "fat_g")
    val fatG: Float,
    @ColumnInfo(name = "is_ai_generated")
    val isAiGenerated: Boolean,
    @ColumnInfo(name = "ai_rationale")
    val aiRationale: String?,
    @ColumnInfo(name = "effective_date")
    val effectiveDateEpochMillis: Long,
    @ColumnInfo(name = "is_active")
    val isActive: Boolean,
)

@Entity(tableName = "food_items")
data class FoodItemEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val category: String,
    @ColumnInfo(name = "serving_size")
    val servingSize: String,
    @ColumnInfo(name = "serving_grams")
    val servingGrams: Float,
    val barcode: String?,
    val source: FoodSource,
)

@Entity(
    tableName = "nutrition_data",
    foreignKeys = [
        ForeignKey(
            entity = FoodItemEntity::class,
            parentColumns = ["id"],
            childColumns = ["food_item_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["food_item_id"], unique = true),
    ],
)
data class NutritionDataEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "food_item_id")
    val foodItemId: String,
    val calories: Int,
    @ColumnInfo(name = "protein_g")
    val proteinG: Float,
    @ColumnInfo(name = "carbs_g")
    val carbsG: Float,
    @ColumnInfo(name = "fat_g")
    val fatG: Float,
    @ColumnInfo(name = "fiber_g")
    val fiberG: Float,
    @ColumnInfo(name = "sodium_mg")
    val sodiumMg: Float,
    @ColumnInfo(name = "iron_mg")
    val ironMg: Float,
    @ColumnInfo(name = "vitamin_a_mcg")
    val vitaminAMcg: Float?,
    @ColumnInfo(name = "vitamin_c_mg")
    val vitaminCMg: Float?,
    @ColumnInfo(name = "vitamin_d_mcg")
    val vitaminDMcg: Float?,
    @ColumnInfo(name = "calcium_mg")
    val calciumMg: Float,
    @ColumnInfo(name = "potassium_mg")
    val potassiumMg: Float,
    @ColumnInfo(name = "is_ai_estimated")
    val isAiEstimated: Boolean,
)

@Entity(
    tableName = "meal_logs",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["user_id"]),
    ],
)
data class MealLogEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "meal_type")
    val mealType: MealType,
    @ColumnInfo(name = "logged_at")
    val loggedAtEpochMillis: Long,
    @ColumnInfo(name = "total_calories")
    val totalCalories: Int,
)

@Entity(
    tableName = "meal_log_items",
    foreignKeys = [
        ForeignKey(
            entity = MealLogEntity::class,
            parentColumns = ["id"],
            childColumns = ["meal_log_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = FoodItemEntity::class,
            parentColumns = ["id"],
            childColumns = ["food_item_id"],
            onDelete = ForeignKey.RESTRICT,
        ),
    ],
    indices = [
        Index(value = ["meal_log_id"]),
        Index(value = ["food_item_id"]),
    ],
)
data class MealLogItemEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "meal_log_id")
    val mealLogId: String,
    @ColumnInfo(name = "food_item_id")
    val foodItemId: String,
    val servings: Float,
    @ColumnInfo(name = "custom_grams")
    val customGrams: Float?,
)

@Entity(tableName = "ingredients")
data class IngredientEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val category: String,
)

@Entity(tableName = "cuisine_types")
data class CuisineTypeEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    val name: String,
)

@Entity(
    tableName = "recipes",
    foreignKeys = [
        ForeignKey(
            entity = CuisineTypeEntity::class,
            parentColumns = ["id"],
            childColumns = ["cuisine_id"],
            onDelete = ForeignKey.RESTRICT,
        ),
    ],
    indices = [
        Index(value = ["cuisine_id"]),
    ],
)
data class RecipeEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "cuisine_id")
    val cuisineId: String,
    val title: String,
    val instructions: String,
    @ColumnInfo(name = "prep_time")
    val prepTimeMinutes: Int,
    @ColumnInfo(name = "cook_time")
    val cookTimeMinutes: Int,
    val servings: Int,
    @ColumnInfo(name = "per_serving_calories")
    val perServingCalories: Int,
    @ColumnInfo(name = "per_serving_protein_g")
    val perServingProteinG: Float,
    @ColumnInfo(name = "per_serving_carbs_g")
    val perServingCarbsG: Float,
    @ColumnInfo(name = "per_serving_fat_g")
    val perServingFatG: Float,
    @ColumnInfo(name = "generated_by_ai")
    val generatedByAi: Boolean,
)

@Entity(
    tableName = "recipe_ingredients",
    foreignKeys = [
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = IngredientEntity::class,
            parentColumns = ["id"],
            childColumns = ["ingredient_id"],
            onDelete = ForeignKey.RESTRICT,
        ),
    ],
    indices = [
        Index(value = ["recipe_id"]),
        Index(value = ["ingredient_id"]),
    ],
)
data class RecipeIngredientEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "recipe_id")
    val recipeId: String,
    @ColumnInfo(name = "ingredient_id")
    val ingredientId: String,
    val quantity: String,
    @ColumnInfo(name = "is_optional")
    val isOptional: Boolean,
)

@Entity(
    tableName = "saved_recipes",
    foreignKeys = [
        ForeignKey(
            entity = UserEntity::class,
            parentColumns = ["id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.CASCADE,
        ),
        ForeignKey(
            entity = RecipeEntity::class,
            parentColumns = ["id"],
            childColumns = ["recipe_id"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
    indices = [
        Index(value = ["user_id"]),
        Index(value = ["recipe_id"]),
    ],
)
data class SavedRecipeEntity(
    @PrimaryKey
    val id: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = "user_id")
    val userId: String,
    @ColumnInfo(name = "recipe_id")
    val recipeId: String,
    @ColumnInfo(name = "saved_at")
    val savedAtEpochMillis: Long,
)
