package com.cardinal.android_app_architecture.number_guess

sealed interface NumberGuessAction {
    data object OnGuessClick: NumberGuessAction
    data class OnNumberTextChange(val numberText: String): NumberGuessAction
    data object OnStartNewGameButtonClick: NumberGuessAction
}