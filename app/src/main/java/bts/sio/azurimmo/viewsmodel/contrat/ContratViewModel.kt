import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import bts.sio.azurimmo.model.Contrat
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo.api.RetrofitInstance
import bts.sio.azurimmo.model.Appartement
import kotlinx.coroutines.launch

class ContratViewModel : ViewModel() {

    // Liste mutable des contrats
    private val _contrats = mutableStateOf<List<Contrat>>(emptyList())
    val contrats: State<List<Contrat>> = _contrats

    private val _contrat = mutableStateOf<Contrat?>(null)
    val contrat: State<Contrat?> = _contrat

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        // Simuler un chargement de données initiales
        getContrats()
    }

    fun getContrats() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getContrats()
                _contrats.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getContrat(contratId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getContratById(contratId)
                if (response != null) {
                    _contrat.value = response

                } else {
                    _errorMessage.value = "Aucun bâtiment trouvé avec l'ID $contratId"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getContratsByAppartementId(appartementId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getContratsByAppartementId(appartementId)
                _contrats.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addContrat(contrat: Contrat) {
        viewModelScope.launch {
            _isLoading.value = true
            try {

                // Envoi à l'API (ici, un POST)
                val response = RetrofitInstance.api.addContrat(contrat)
                if (response.isSuccessful) {
                    // Ajout réussi, on met à jour la liste des bâtiments
                    getContrats() // Recharge les bâtiments pour inclure le nouveau
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du contrat : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

}