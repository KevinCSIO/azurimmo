package bts.sio.azurimmo.views.locataire

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import bts.sio.azurimmo.model.Locataire

@Composable
fun LocataireCard(locataire: Locataire, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp),
        shape = RoundedCornerShape(8.dp)    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row {
                Text(
                    text = "Date de Naissance : ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = locataire.dateN,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row {
                Text(
                    text = "Lieu de Naissance : ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = locataire.lieuN,
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Row {
                Text(
                    text = "Nom : ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = locataire.nom,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Row {
                Text(
                    text = "Prénom : ",
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = locataire.prenom,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
