package com.cardinal.android_app_architecture

import com.cardinal.android_app_architecture.number_guess.NumberGuessScreen

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import com.cardinal.android_app_architecture.number_guess.NumberGuessState
import org.junit.Rule
import org.junit.Test

class NumberGuessScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testNumberInputAndGuessButton() {
        composeTestRule.setContent {
            NumberGuessScreen(
                state = NumberGuessState(),
                onAction = {}
            )
        }

        val numberTextField = composeTestRule.onNodeWithTag("numberTextField")
        numberTextField.performClick()
        numberTextField.performTextInput("42")

        composeTestRule.waitForIdle()

        numberTextField.assertTextEquals("42")

        val guessButton = composeTestRule.onNodeWithText("Make guess")
        guessButton.performClick()

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithText("Your guess is...").assertExists()
    }

    @Test
    fun testStartNewGameButtonAppearsAfterCorrectGuess() {
        val stateWithCorrectGuess = NumberGuessState(
            guessText = "Correct guess!",
            isGuessCorrect = true
        )

        composeTestRule.setContent {
            NumberGuessScreen(
                state = stateWithCorrectGuess,
                onAction = {}
            )
        }

        composeTestRule.onNodeWithText("Start new game").assertIsDisplayed()

        val startNewGameButton = composeTestRule.onNodeWithText("Start new game")
        startNewGameButton.performClick()
    }
}
