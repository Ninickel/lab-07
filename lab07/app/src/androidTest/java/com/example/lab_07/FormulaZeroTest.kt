package com.example.lab_07

import androidx.compose.ui.test.junit4.v2.createAndroidComposeRule
import androidx.compose.ui.test.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_drivers_add_driver_clear_drivers_and_return_home(){
        //navigate to DriversScreen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        //Input Max Verstappen into name input
        composeTestRule
            .onNodeWithTag("nameInput")
            .performTextInput("Max Verstappen")

        //Check if name is present
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertExists()

        //add driver name to list
        composeTestRule
            .onNodeWithTag("addNameButton")
            .performClick()

        // return to home screen
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        //Check if name is gone
        composeTestRule
            .onNodeWithText("Max Verstappen")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()
    }
}

