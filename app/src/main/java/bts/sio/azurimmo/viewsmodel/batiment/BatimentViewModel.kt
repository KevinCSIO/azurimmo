import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import bts.sio.azurimmo.model.Batiment
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo.api.RetrofitInstance
import kotlinx.coroutines.launch

class BatimentViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _batiments = mutableStateOf<List<Batiment>>(emptyList())
    val batiments: State<List<Batiment>> = _batiments

    private val _batiment = mutableStateOf<Batiment?>(null)
    val batiment: State<Batiment?> = _batiment

    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    private val _errorMessage = mutableStateOf<String?>(null)
    val errorMessage: State<String?> = _errorMessage

    init {
        // Simuler un chargement de données initiales
        getBatiments()
    }

    fun getBatiments() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatiments()
                _batiments.value = response
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun getBatiment(batimentId: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getBatimentById(batimentId)
                if (response != null) {
                    _batiment.value = response
                } else {
                    _errorMessage.value = "Aucun bâtiment trouvé avec l'ID $batimentId"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
                println("pas de chargement")
            }
        }
    }

    fun addBatiment(batiment: Batiment) {
        viewModelScope.launch {
            _isLoading.value = true
            try {

                // Envoi à l'API (ici, un POST)
                val response = RetrofitInstance.api.addBatiment(batiment)
                if (response.isSuccessful) {
                    // Ajout réussi, on met à jour la liste des bâtiments
                    getBatiments() // Recharge les bâtiments pour inclure le nouveau
                } else {
                    _errorMessage.value = "Erreur lors de l'ajout du bâtiment : ${response.message()}"
                }
            } catch (e: Exception) {
                _errorMessage.value = "Erreur : ${e.message}"
            } finally {
                _isLoading.value = false
            }
        }
    }
}


