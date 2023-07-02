class Mage(name: String): Human(name){
    override fun attack(){
        if(mana >= 5) {
            println("$name use Fireball!")
            mana = mana - 5
        }
        else{
            super.attack()
        }
    }
}
fun main(){
    val mage = Mage("Andy")
    mage.attack()
}