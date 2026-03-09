package com.nbapps.theplatediary.core.data.local.model

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
