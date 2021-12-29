package com.example.utils

interface DtoInterface<T, K> {
    fun mapFrom(value: T): K
    fun mapTo(value: K): T
}