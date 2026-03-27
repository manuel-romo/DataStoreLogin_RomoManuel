package romo.manuel.datastorelogin_romomanuel.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import romo.manuel.datastorelogin_romomanuel.data.DataStoreManager

class AuthViewModel (private val dataStore: DataStoreManager): ViewModel() {

    // Aqui se hace una "suscripcion" a nuestras variables.
    val isLoggedIn = dataStore.isLoggedInFlow.stateIn(

        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        false

    )

    fun login(user: String, pass: String){
        if(user == "admin" && pass == "1234"){
            // Aqui se lanza "nuestra función".
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