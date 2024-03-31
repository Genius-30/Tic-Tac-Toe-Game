package com.example.composetictactoe.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetictactoe.BoardCellValue
import com.example.composetictactoe.R
import com.example.composetictactoe.UserAction
import com.example.composetictactoe.models.TicTacToeViewModel
import com.example.composetictactoe.ui.theme.Dark_Purple

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Game_Screen(
    onBack: () -> Unit,
    viewModel: TicTacToeViewModel
) {

    val state = viewModel.state

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Dark_Purple)
            .padding(10.dp),
        topBar = {
            androidx.compose.material3.TopAppBar(
                modifier = Modifier
                    .background(color = Dark_Purple)
                    .height(55.dp)
                    .clip(RoundedCornerShape(16.dp)),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Tic Tac Toe",
                            fontSize = 22.sp,
                            fontWeight = FontWeight.SemiBold,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = Dark_Purple,
                    navigationIconContentColor = Dark_Purple,
                    actionIconContentColor = Dark_Purple
                ),
                actions = {
                    IconButton(onClick = {
                        viewModel.onAction(
                            UserAction.PlayAgainButtonCLicked
                        )
                    }) {
                        Icon(
                            imageVector = Icons.Default.Refresh,
                            contentDescription = "Play Again"
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .background(Dark_Purple),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = state.hintText,
                    fontSize = 24.sp,
                    color = Color.White
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(3),
                    modifier = Modifier
                        .fillMaxWidth(0.9f)
                        .aspectRatio(1f)
                ) {
                    viewModel.boardItems.forEach { (cellNo, boardCellValue) ->

                        item {
                            Box(
                                modifier = Modifier
                                    .padding(5.dp)
                                    .width(75.dp)
                                    .aspectRatio(1f)
                                    .clip(RoundedCornerShape(10.dp))
                                    .background(Color.White)
                                    .padding(15.dp)
                                    .clickable(
                                        interactionSource = MutableInteractionSource(),
                                        indication = null
                                    ) {
                                        viewModel.onAction(UserAction.BoardTapped(cellNo))
                                    },
                                contentAlignment = Alignment.Center
                            ) {
                                this@Column.AnimatedVisibility(
                                    visible = viewModel.boardItems[cellNo] != BoardCellValue.NONE,
                                    enter = scaleIn(tween(1000))
                                ) {
                                    if (boardCellValue == BoardCellValue.CROSS) {
                                        Icon(
                                            painter = painterResource(id = R.drawable._98889_x_icon),
                                            contentDescription = null,
                                            tint = Dark_Purple
                                        )
                                    } else if (boardCellValue == BoardCellValue.CIRCLE) {
                                        Icon(
                                            painter = painterResource(id = R.drawable._665789_o_alphabet_icon),
                                            contentDescription = null,
                                            tint = Dark_Purple
                                        )
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

    }

}