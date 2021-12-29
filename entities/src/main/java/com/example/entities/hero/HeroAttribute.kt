package com.example.entities.hero

sealed class HeroAttribute(
    val abbreviation: String,
    val value: String
) {
    object Agility : HeroAttribute(
        abbreviation = "agi",
        value = "Agility"
    )

    object Strength : HeroAttribute(
        abbreviation = "str",
        value = "Strength"
    )

    object Intelligence : HeroAttribute(
        abbreviation = "int",
        value = "Intelligence"
    )

    object Unknown : HeroAttribute(
        abbreviation = "Unknown",
        value = "Unknown"
    )
}

fun mapFromAbbreviationToValue(abbreviation: String): HeroAttribute {
    return when (abbreviation) {
        HeroAttribute.Agility.abbreviation -> {
            HeroAttribute.Agility
        }
        HeroAttribute.Strength.abbreviation -> {
            HeroAttribute.Strength
        }
        HeroAttribute.Intelligence.abbreviation -> {
            HeroAttribute.Intelligence
        }
        else -> HeroAttribute.Unknown
    }
}


