import kotlin.math.*

open class Human(val name: String){
    var mana = 100f
    open fun attack(){
        println("$name use Fist Attack!")
    }
    val manaFlag: Boolean
        get() = (mana>0)
}
fun main(){
    val human = Human("Jason")
    human.attack()

}