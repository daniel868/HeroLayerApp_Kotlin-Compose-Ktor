package com.example.entities.hero

sealed class HeroAttackType(
    val value: String
) {
    object Melee : HeroAttackType(
        value = "Melee"
    )

    object Ranged : HeroAttackType(
        value = "Ranged"
    )

    object Unknown : HeroAttackType(
        value = "Unknown"
    )
}

fun mapFromValueToHeroAttackType(value: String): HeroAttackType {
    return when (value) {
        HeroAttackType.Melee.value -> {
            HeroAttackType.Melee
        }
        HeroAttackType.Ranged.value -> {
            HeroAttackType.Ranged
        }
        else -> HeroAttackType.Unknown
    }
}