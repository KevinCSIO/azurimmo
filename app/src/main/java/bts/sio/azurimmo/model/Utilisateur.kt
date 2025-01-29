package bts.sio.azurimmo.model

class Utilisateur (var login: String=""){
    constructor(nom:String, prenom:String):this(nom){
        this.nom=nom
        this.prenom=prenom
    }
    var nom: String=""
    var prenom: String=""
    var password: String=""
        set(value){ // Nouvelle valeur du password
            if(value.length<10) // Test si la valeur est inférieure à 10 alors
                throw RuntimeException("Password is too short") // Explose le programme
            field=value
        }
    val todos = mutableListOf<Todo>()
}