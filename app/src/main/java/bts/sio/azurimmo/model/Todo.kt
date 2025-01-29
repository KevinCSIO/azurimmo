package bts.sio.azurimmo.model
/* En java :
class Todo{
private String nom;
private List<Item> items=new ArrayList<Items>();
public Todo(String nom){
    this.nom=nom;
}
*/
class Todo (var nom: String=""){
    val items = mutableListOf<Item>()
}
