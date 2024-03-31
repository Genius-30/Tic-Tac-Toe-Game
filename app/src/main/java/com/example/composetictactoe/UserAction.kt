package com.example.composetictactoe

sealed class UserAction {
    data object PlayAgainButtonCLicked: UserAction()
    data class BoardTapped(val cellNo: Int): UserAction()
}