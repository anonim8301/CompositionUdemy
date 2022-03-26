package com.example.composition.domain.usecases

import com.example.composition.common.CONSTANTS.COUNT_OF_OPTIONS
import com.example.composition.domain.entity.Question
import com.example.composition.domain.repository.GameRepository

class GenerateQuestionUseCase(
    private val repository: GameRepository,
) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
    }
}