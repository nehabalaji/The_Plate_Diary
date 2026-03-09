package com.nbapps.theplatediary.core.data.local.model

import androidx.room.TypeConverter

class RoomConverters {
    @TypeConverter
    fun fromAuthProvider(value: AuthProvider): String = value.name

    @TypeConverter
    fun toAuthProvider(value: String): AuthProvider = AuthProvider.valueOf(value)

    @TypeConverter
    fun fromSex(value: Sex): String = value.name

    @TypeConverter
    fun toSex(value: String): Sex = Sex.valueOf(value)

    @TypeConverter
    fun fromActivityLevel(value: ActivityLevel): String = value.name

    @TypeConverter
    fun toActivityLevel(value: String): ActivityLevel = ActivityLevel.valueOf(value)

    @TypeConverter
    fun fromDietaryPreference(value: DietaryPreference): String = value.name

    @TypeConverter
    fun toDietaryPreference(value: String): DietaryPreference = DietaryPreference.valueOf(value)

    @TypeConverter
    fun fromGoalType(value: GoalType): String = value.name

    @TypeConverter
    fun toGoalType(value: String): GoalType = GoalType.valueOf(value)

    @TypeConverter
    fun fromFoodSource(value: FoodSource): String = value.name

    @TypeConverter
    fun toFoodSource(value: String): FoodSource = FoodSource.valueOf(value)

    @TypeConverter
    fun fromMealType(value: MealType): String = value.name

    @TypeConverter
    fun toMealType(value: String): MealType = MealType.valueOf(value)
}
