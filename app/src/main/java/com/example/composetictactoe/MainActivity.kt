package com.example.composetictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composetictactoe.models.TicTacToeViewModel
import com.example.composetictactoe.screens.Game_Screen
import com.example.composetictactoe.screens.Start_Screen
import com.example.composetictactoe.ui.theme.ComposeTicTacToeTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<TicTacToeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTicTacToeTheme {

                TicTacToeApp(viewModel)

            }
        }
    }
}

@Composable
fun TicTacToeApp(viewModel: TicTacToeViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start") {

        composable(route = "start") {
            Start_Screen {
                navController.navigate(route = "main")
            }
        }

        composable(route = "main") {
            Game_Screen(
                onBack = {
                    navController.popBackStack()
                },
                viewModel = viewModel
            )
        }

    }

}