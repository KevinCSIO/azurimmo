package bts.sio.azurimmo.viewsmodel.locataire

import android.adservices.adid.AdId
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import bts.sio.azurimmo.model.Locataire
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo.api.RetrofitInstance
import bts.sio.azurimmo.model.Contrat
import kotlinx.coroutines.launch

class LocataireViewModel : ViewModel() {

    private val _locataires = mutableStateOf<List<Locataire>>(emptyList())
    val locataires: State<List<Locataire>> = _locataires

    private val _locataire = mutableStateOf<Locataire?>(null)
    val locataire: State<Locataire?> = _locataire

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        // Simuler un chargement de données initiales
        getLocataires()
    }

    fun getLocataires() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getLocataires()
                _locataires.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getLocataire(locataireId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getLocataireById(locataireId)
                if (response != null) {
                    _locataire.value = response

                } else {
                    _errorMessage.value = "Aucun locataire trouvé avec l'ID $locataireId"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getLocatairesByContratId(contratId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getLocatairesByContratId(contratId)
                _locataires.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addLocataire(locataire: Locataire) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                // Envoi à l'API (ici, un POST)
                val response = RetrofitInstance.api.addLocataire(locataire)
                if (response.isSuccessful) {
                    // Ajout réussi, on met à jour la liste des locataires
                    getLocataires() // Recharge les locataires pour inclure le nouveau
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du locataire : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}
