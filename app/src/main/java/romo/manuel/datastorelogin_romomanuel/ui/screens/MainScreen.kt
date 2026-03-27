package romo.manuel.datastorelogin_romomanuel.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import romo.manuel.datastorelogin_romomanuel.viewmodel.AuthViewModel

@Composable
fun MainScreen(viewModel: AuthViewModel){

    // Esta clase es para hacer el inicio más limpio y no meterlo en el MainActivity
    // Aqui si es reactivo, o sea, lo esta observando.
    val isLogged by viewModel.isLoggedIn.collectAsState()
    if(isLogged){
        // Para que el Home, pueda limpiar el datastore, se le manda el  ViewModel como parámetro
        HomeScreen(
            {viewModel.logout()}
        )
    } else{
        // Para esta práctica, mandaremos el viewmodel, porque la pantalla le tiene que mandar parámetros de ella.
        LoginScreen(viewModel)
    }


}