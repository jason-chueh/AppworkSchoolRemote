# screenshot
![](https://hackmd.io/_uploads/Byr41QW92.png)

# 1
Encapsulation in Kotlin refers to the practice of bundling properties and methods together within a class and controlling access to them.
The benefits are: information hiding and data integrity.
# 2
Enum class can be thought of as a category that consists of limited number of objects/constants.
For exmaple, we can declare a enum class **Direction**.
```
enum class Direction{
EAST, WEST, NORTH, SOUTH
}
```
If you are ordering a to-do list by the priority of each element. We can first mark each state with one of the following priority : MINOR, NORMAL, MAJOR, CRITICAL. The set of priority state can be implemented as enum class.
```
enum class Priority(val value: Int){
MINOR(-1),
NORMAL(0),
MAJOR(1),
CRITICAL(10)
}
```
Noted that the enum class itself is not an object but a category that involves objects, so if we want to use the value of enum class, we should declare as:
```
val priority = Priority.MINOR
```
This also shows that Enum class provide a convenient way to work with a fixed set of values in a type-safe and readable manner, which is the reason why we should use it.
# 3
## methods
Enum class have some built-in methods:
1. .value
return the value of an object
```
println(priority.value)
println(Priority.MINOR.value)
// -1
```
2. .values()
return the list of objects in the enum class
```
for(priorityInList in Priority.values()){
println(priorityInList)
}
//MINOR\n NORMAL\n MAJOR\n CRITICAL\n
```
3. valueOf(nameOfObject: String)
lookup the name of object and return the corresponding value
```
println(Priority.valueOf(" MINOR "))
```
## override function
We can modify the built-in functions for each of the object, and can also declare abstract function in Enum class.
```
enum class Priority(val value: Int){
    MINOR(-1){
        override fun toString(): String {
            return "MINOR PRIORITY"
            }
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
             },

    NORMAL(0){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
             },
    MAJOR(1){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
            },
    CRITICAL(10){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
    };
    abstract fun text(): String
}
```
## companion object
If we want to define any shared behavior or properties specific to the enum class itself, we can define them in **companion object**.
```
enum class Priority(val value: Int){
    MINOR(-1),
    NORMAL(0),
    MAJOR(1),
    CRITICAL(10)
    companion object {
        fun getPriorities(): List<Priority> {
            return listOf(MINOR, NORMAL, MAJOR, CRITICAL)
        }
    }
}

fun main(){
    val prioroties = Priority.getPriorities()
    println(prioroties)
    //[MINOR PRIORITY, NORMAL, MAJOR, CRITICAL]
}
```
### override and abstract fun
```
enum class Priority(val value: Int){
    MINOR(-1){
        override fun toString(): String {
            return "MINOR PRIORITY"
            }
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
             },

    NORMAL(0){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
             },
    MAJOR(1){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
            },
    CRITICAL(10){
        override fun text(): String{
            throw UnsupportedOperationException("not implemented")
        }
    };
    abstract fun text(): String
}
```
# 4
Linear Layout aligns all the element horizontally or vertically while relative layout arranges the positions of elements based on the relationship with siblings or container.

# 5
1. Constraint Layout is much more user friendly than Relative Layout. It offers some powerful features such as chains, guideline and Ratio so that we no longer have to take plenties of hours adjusting the relative position of all the elements. It also provides a better editor interface that is easier to interact with.
2. Constraint Layout is way more flexible in comparison to Linear Layout. The enforced alignment property in Linear Layout is double-edged. When implementing a complicated design in Linear Layout, we have to sidestep the alignment property by nesting another Layout, leading to efficiency issue in runtime. Constraint Layout can create the same intricate design with flat view hierarchy, improving the performance a lot.
To wrap it up, Constraint Layout is a better version of Relative Layout and Linear Layout.