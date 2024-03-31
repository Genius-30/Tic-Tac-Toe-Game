package com.example.composetictactoe

data class GameState(

    val hintText: String = "Player 'X' turn",
    val currentTurn: BoardCellValue = BoardCellValue.CROSS,
    val hasWon: Boolean = false
)

enum class BoardCellValue{
    CIRCLE,
    CROSS,
    NONE
}