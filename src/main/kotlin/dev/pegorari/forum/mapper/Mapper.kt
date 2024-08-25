package dev.pegorari.forum.mapper

interface Mapper<T, U> {

    fun map(t: T): U
}