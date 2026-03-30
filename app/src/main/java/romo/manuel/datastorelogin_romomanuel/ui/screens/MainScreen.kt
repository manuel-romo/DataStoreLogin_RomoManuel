package romo.manuel.datastorelogin_romomanuel.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import romo.manuel.datastorelogin_romomanuel.viewmodel.AuthViewModel

/**
 * Manuel Romo López
 * ID: 00000253080
 */
@Composable
fun MainScreen(viewModel: AuthViewModel){

    // Esta clase es para hacer el inicio más limpio y no incluirlo en el MainActivity
    // Aquí sí es reactivo, se está observando el estado de la sesión.
    val isLogged by viewModel.isLoggedIn.collectAsState()
    if(isLogged){
        HomeScreen(
            {viewModel.logout()}
        )
    } else{
        // En esta práctica se envía el AuthViewModel, porque la pantalla le tiene que enviar
        // los parámetros de nombre de usuario y contraseña.
        LoginScreen(viewModel)
    }

}