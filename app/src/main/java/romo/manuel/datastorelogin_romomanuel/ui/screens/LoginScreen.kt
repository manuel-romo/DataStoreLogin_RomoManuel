package romo.manuel.datastorelogin_romomanuel.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import romo.manuel.datastorelogin_romomanuel.data.DataStoreManager
import romo.manuel.datastorelogin_romomanuel.viewmodel.AuthViewModel

/**
 * Manuel Romo López
 * ID: 00000253080
 */

@Composable
fun LoginScreen(
    viewModel: AuthViewModel
){

    val context = LocalContext.current
    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(36.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            text = "Inicio de sesión",
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(modifier = Modifier.height(16.dp))


        OutlinedTextField(
            value = user,
            onValueChange = { user = it },
            label = { Text("Nombre de usuario") },
            modifier = Modifier
                .fillMaxWidth()
        )
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it },
            label = { Text("Contraseña") },
            modifier = Modifier
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(28.dp))
        Button(
            onClick = {

                if(user.isBlank() || user.isBlank()){
                    Toast.makeText(context, "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show()
                } else{
                    viewModel.login(user, pass)
                }


            },
            modifier = Modifier.fillMaxWidth()
        ) { Text(text = "Ingresar") }
    }

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview(){
    LoginScreen(AuthViewModel(DataStoreManager(LocalContext.current)))

}