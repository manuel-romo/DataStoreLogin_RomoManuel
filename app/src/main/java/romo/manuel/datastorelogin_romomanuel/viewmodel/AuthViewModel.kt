package romo.manuel.datastorelogin_romomanuel.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import romo.manuel.datastorelogin_romomanuel.data.DataStoreManager

/**
 * Manuel Romo López
 * ID: 00000253080
 */
class AuthViewModel (private val dataStore: DataStoreManager): ViewModel() {

    // Suscripción a nuestras variables.
    val isLoggedIn = dataStore.isLoggedInFlow.stateIn(

        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false

    )

    fun login(user: String, pass: String){
        if(user == "admin" && pass == "1234"){
            // Aquí se lanza la función para guardar el inicio de sesión.
            viewModelScope.launch {
                dataStore.saveSession(user)
            }
        }
    }

    fun logout(){
        viewModelScope.launch {
            dataStore.logout()
        }
    }

}