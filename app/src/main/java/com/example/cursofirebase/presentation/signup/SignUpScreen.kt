package com.example.cursofirebase.presentation.signup

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursofirebase.R
import com.example.cursofirebase.ui.theme.Black
import com.example.cursofirebase.ui.theme.SelectedField
import com.example.cursofirebase.ui.theme.UnselectedField
import com.google.firebase.auth.FirebaseAuth

@Composable
fun SignUpScreen(auth: FirebaseAuth) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(modifier = Modifier
        .fillMaxSize()
        .background(Black)
        .padding(horizontal = 30.dp)
        .padding(top = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row() {
            Icon(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "",
                tint = White,
                modifier = Modifier.padding(top = 32.dp)
                    .padding(vertical = 20.dp)
                    .size(25.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
        }

        Text(
            "Email",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 40.dp)
        )
        TextField(
            email,
            onValueChange = { email = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = UnselectedField,
                focusedContainerColor = SelectedField,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            "Password",
            color = White,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier.padding(top = 40.dp)
        )
        TextField(
            password,
            onValueChange = { password = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = UnselectedField,
                focusedContainerColor = SelectedField,
            )
        )
        Spacer(modifier = Modifier.height(5.dp))
        Button(onClick = {
            auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.i("Aris", "Sign Up Successful")
                } else {
                    Log.i("Aris", "Sign Up Failed")
                }
            } },
            modifier = Modifier.padding(top = 20.dp)
        ){
            Text("Sign up", color = White, fontWeight = FontWeight.Bold, fontSize = 15.sp, )
        }
    }
}