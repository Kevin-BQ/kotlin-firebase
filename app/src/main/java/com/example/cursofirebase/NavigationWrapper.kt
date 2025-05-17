package com.example.cursofirebase

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cursofirebase.presentation.initial.InitialScreen
import com.example.cursofirebase.presentation.login.LoginScreen
import com.example.cursofirebase.presentation.signup.SignUpScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun NavigationWrapper(navHostController: NavHostController, auth: FirebaseAuth) {
    NavHost(navController = navHostController, startDestination = "initial") {
        composable("initial") {
            InitialScreen(
                navigateToLogin = { navHostController.navigate("LogIn") },
                navigateToSignUp = { navHostController.navigate("signUp") }
            )
        }
        composable("LogIn") {
            LoginScreen(auth)
        }
        composable("signUp") {
            SignUpScreen(auth)
        }
    }
}