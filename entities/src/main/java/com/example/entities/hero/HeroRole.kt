package com.example.entities.hero

sealed class HeroRole(
    val value: String
) {
    object Carry : HeroRole(
        value = "Carry"
    )

    object Escape : HeroRole(
        value = "Escape"
    )

    object Nuker : HeroRole(
        value = "Nuker"
    )

    object Initiator : HeroRole(
        value = "Initiator"
    )

    object Durable : HeroRole(
        value = "Durable"
    )

    object Disable : HeroRole(
        value = "Disable"
    )

    object Jungler : HeroRole(
        value = "Jungler"
    )

    object Support : HeroRole(
        value = "Support"
    )

    object Pusher : HeroRole(
        value = "Pusher"
    )

    object Disabler : HeroRole(
        value = "Disabler"
    )

    object Unknown : HeroRole(
        value = "Unkwnown"
    )
}

fun mapFromValueToHeroRole(value: String): HeroRole {
    return when (value) {
        HeroRole.Carry.value -> {
            HeroRole.Carry
        }
        HeroRole.Escape.value -> {
            HeroRole.Escape
        }
        HeroRole.Nuker.value -> {
            HeroRole.Nuker
        }
        HeroRole.Initiator.value -> {
            HeroRole.Initiator
        }
        HeroRole.Durable.value -> {
            HeroRole.Carry
        }
        HeroRole.Disable.value -> {
            HeroRole.Disable
        }
        HeroRole.Jungler.value -> {
            HeroRole.Jungler
        }
        HeroRole.Support.value -> {
            HeroRole.Support
        }
        HeroRole.Pusher.value -> {
            HeroRole.Pusher
        }
        HeroRole.Disabler.value -> {
            HeroRole.Disabler
        }
        else -> HeroRole.Unknown
    }
}
