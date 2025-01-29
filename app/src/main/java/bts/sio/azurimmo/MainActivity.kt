package bts.sio.azurimmo

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import bts.sio.azurimmo.model.Utilisateur
import bts.sio.azurimmo.views.appartement.AppartementList
import bts.sio.azurimmo.views.batiment.BatimentList
import okhttp3.internal.Util

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //BatimentList()
            AppartementList()
        }
    }
}
// Fonction pour prévisualiser l'interface
@Preview(showBackground = true)
@Composable
fun PreviewBatimentList() {
    BatimentList()
}
// Fonction pour prévisualiser l'interface
@Preview(showBackground = true)
@Composable
fun PreviewAppartementList() {
    AppartementList()
}

fun main(){
    val u = Utilisateur() // Modification du login dans une constante
    u.login="kcamus"
    println(u.login)

    val u2=Utilisateur("Bob", "D")
    try{
        u2.password="123456"
    }catch (e:Exception){
        println("Mot de passe un peu court !")
    }
    println(u2.login)

}
