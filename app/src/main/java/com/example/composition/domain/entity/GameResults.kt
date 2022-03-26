package com.example.composition.domain.entity

data class GameResults(
    val winOrNot: Boolean,
    val countOfRightAnswers: Int,
    val countOfQuestions: Int,
    val gameSettings:GameSettings
)