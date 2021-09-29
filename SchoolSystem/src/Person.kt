/**
 * Person.kt
 *
 * Abstract class representing a person. Cannot be instantiated, must be instantiated as a subclass, representing
 * a more specific type of person. Has basic fields and methods that are applicable for all people.
 */
abstract class Person(name: String) {
    protected var name: String // variable is protected so it is accessible by subclasses, var since names can change

    // Constructor in Kotlin
    init {
        this.name = name
    }

    // setter method
    public fun changeName(newName: String) {
        name = newName
    }

    /**
     * Implemented method for all Person objects to return their name attribute
     */
    public fun getPersonName(): String {
        return this.name
    }

    /**
     * Abstract method, meaning subclasses must implement it. When implemented, should return a String representing
     * the Person's role.
     *
     * Returns String representing Person's role
     */
    public abstract fun getRole(): String

    /**
     * Implemented method for all Person objects to return an introduction String
     */
    public fun introduce() {
        println("Hi, my name is ${this.name}")
    }
}