package com.example.composetictactoe.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetictactoe.R
import com.example.composetictactoe.ui.theme.Dark_Purple

@Composable
fun Start_Screen(onStart: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Dark_Purple),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            painter = painterResource(id = R.drawable.tic_tac_toe_logo),
            contentDescription = null,
            modifier = Modifier
                .width(275.dp)
                .wrapContentHeight()
                .padding(top = 150.dp),
            tint = Color.White
        )
        Spacer(modifier = Modifier.height(350.dp))
        Button(
            modifier = Modifier
                .width(270.dp)
                .height(55.dp),
            colors = ButtonDefaults.buttonColors(Color.White),
            shape = RoundedCornerShape(10.dp),
            onClick = { onStart() }
        ) {
            Text(
                text = "Play Game",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Dark_Purple
            )
        }
    }

}