package com.example.cursofirebase.presentation.initial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursofirebase.R
import com.example.cursofirebase.ui.theme.BackgroundButton
import com.example.cursofirebase.ui.theme.Black
import com.example.cursofirebase.ui.theme.Gray
import com.example.cursofirebase.ui.theme.Green
import com.example.cursofirebase.ui.theme.ShapeButton

@Preview
@Composable
fun InitialScreen(navigateToLogin: () -> Unit = {}, navigateToSignUp: () -> Unit = {}){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(colors = listOf(Gray, Black), startY = 1f, endY = 600f)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(
            painter = painterResource(id = R.drawable.spotify),
            contentDescription = "Spotify",
            modifier = Modifier.clip(CircleShape)
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            "Millions of Songs.",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            "Free on Spotify.",
            color = Color.White,
            fontSize = 38.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { navigateToSignUp() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp)
                .padding(horizontal = 32.dp),
            colors = ButtonDefaults
                .buttonColors(
                    containerColor = Green
                )
        ){
            Text("Sign up free", color = Black, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable {  },
            painter = painterResource(id = R.drawable.google),
            "Continue with Google"
        )
        Spacer(modifier = Modifier.height(8.dp))
        CustomButton(
            Modifier.clickable {  },
            painter = painterResource(id = R.drawable.facebook),
            "Continue with Facebook"
        )
        Text(
            "Log in",
            color = Color.White,
            modifier = Modifier.padding(top = 24.dp)
                .clickable { navigateToLogin() },
            fontWeight = FontWeight.Bold,
            )
        Spacer(modifier = Modifier.weight(1f))
    }

}

@Composable
fun CustomButton(modifier: Modifier, painter: Painter, title: String, ){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(48.dp)
        .padding(horizontal = 32.dp)
        .background(BackgroundButton)
        .border(2.dp, ShapeButton, CircleShape),
        contentAlignment = Alignment.CenterStart
    ){
        Image(
            painter = painter,
            contentDescription = "Google",
            modifier = Modifier.padding(start = 20.dp).size(18.dp)
        )
        Text(
            title,
            color = Color.White,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
        )
    }
}