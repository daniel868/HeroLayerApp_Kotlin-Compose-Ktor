package com.example.entities.remote

import com.example.entities.hero.*
import com.example.entities.remote.EndPoint.BASE_URL
import com.example.utils.DtoInterface

class RemoteDto : DtoInterface<Hero, HeroRemoteDto> {
    override fun mapFrom(value: Hero): HeroRemoteDto {
        TODO("Not yet implemented")
    }

    override fun mapTo(value: HeroRemoteDto): Hero {
        return Hero(
            id = value.id,
            localizedName = value.localizedName,
            primaryAttribute = mapFromAbbreviationToValue(value.primaryAttribute),
            attackType = mapFromValueToHeroAttackType(value.attackType),
            roles = mapRoles(value.roles),
            img = "$BASE_URL${value.img}",
            icon = "$BASE_URL${value.icon}",
            baseHealth = value.baseHealth,
            baseHealthRegen = value.baseHealthRegen,
            baseMana = value.baseMana,
            baseManaRegen = value.baseManaRegen,
            baseArmor = value.baseArmor,
            baseMoveRate = value.baseMoveRate,
            baseAttackMin = value.baseAttackMin,
            baseAttackMax = value.baseAttackMax,
            baseStr = value.baseStr,
            baseAgi = value.baseAgi,
            baseInt = value.baseInt,
            strGain = value.strGain,
            agiGain = value.agiGain,
            intGain = value.intGain,
            attackRange = value.attackRange,
            projectileSpeed = value.projectileSpeed,
            attackRate = value.attackRate,
            moveSpeed = value.moveSpeed,
            turnRate = value.turnRate,
            legs = value.legs,
            turboPicks = value.turboPicks,
            turboWins = value.turboWins,
            proWins = value.proWins ?: 0,
            proPick = value.proPick ?: 0,
            firstPick = value.firstPick,
            firstWin = value.firstWin,
            secondPick = value.secondPick,
            secondWin = value.secondWin,
            thirdPick = value.thirdPick,
            thirdWin = value.thirdWin,
            fourthPick = value.fourthPick,
            fourthWin = value.fourthWin,
            fifthPick = value.fifthPick,
            fifthWin = value.fifthWin,
            sixthPick = value.sixthPick,
            sixthWin = value.sixthWin,
            seventhPick = value.seventhPick,
            seventhWin = value.seventhWin,
            eighthWin = value.eighthWin,
            eighthPick = value.eighthPick,
        )
    }

    private fun mapRoles(roles: List<String>): List<HeroRole> {
        return roles.map {
            mapFromValueToHeroRole(it)
        }
    }
}