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
    override fun toString(): String {
        val cond=if (items.size>0) " avec ${items.size} items" else ""
        return "$nom $cond"
    }
}
