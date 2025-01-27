import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.*
import androidx.lifecycle.viewModelScope
import bts.sio.azurimmo.model.Appartement
import kotlinx.coroutines.launch

// ViewModel pour gérer les données des bâtiments
class AppartementViewModel : ViewModel() {

    // Liste mutable des bâtiments
    private val _appartements = mutableStateOf(emptyList<Appartement>())
    val appartements: State<List<Appartement>> = _appartements

    init {
        // Simuler un chargement de données initiales
        getAppartements()
    }

    // Fonction pour simuler le chargement de bâtiments
    private fun getAppartements() {
        viewModelScope.launch {
            _appartements.value = listOf(
                Appartement(1, 12, 500.0, 15, "Appartement de luxe"),
                Appartement(2, 789, 50.0, 6, "Appartement en ville"),
                Appartement(3, 56, 100.0, 9, "Appartement")
            )
        }
    }
}