/**
 * Professor.kt
 *
 * Class representing a University professor. Inherits from Person. Has fields for the professor's ID number and list of
 * classes that they teach.
 */
class Professor(name: String, idNumber: Int): Person(name) {
    val idNumber: Int // use val keyword since professor's ID should never change
    val classList: MutableList<SchoolClass> // must be a mutable list so classes can be added/removed

    // Constructor in Kotlin
    init {
        this.idNumber = idNumber //'this' keyword used as in Java to refer to current object
        classList = mutableListOf<SchoolClass>()
    }

    // getter methods
    public fun getID(): Int {
        return idNumber
    }
    public fun getClasses(): MutableList<SchoolClass> {
        return classList
    }

    /**
     * Allows SchoolClass to be added to the Professor's classList
     *
     * c - The SchoolClass object being added to the Professor's classlist
     */
    public fun addClass(c : SchoolClass) {
        for(o in classList) { // Kotlin for loop
            if (o.getID() == c.getID())
                return
        }
        classList.add(c)
    }

    /**
     * Removes a class from the Professor's classlist and returns it
     *
     * SchoolClass - the SchoolClass to be removed
     * Returns the removed SchoolClass
     */
    public fun removeClass(c: SchoolClass): SchoolClass? {
        for(o in classList) {
            if (o.getID() == c.getID())
                classList.remove(o)
            return o
        }
        return null
    }

    /**
     * Since the superclass has an abstract getRole method, this class must implement it, in this case returning
     * the String "Professor"
     */
    public override fun getRole(): String {
        return "Professor"
    }

    // toString
    //'$' used in strings to insert variable values in Kotlin
    public override fun toString() : String {
        var retString = "ID: $idNumber\nProfessor Name: $name\nClasses:\n"
        for (c in classList) {
            retString+="   ${c.getTitle()}\n"
        }
        return retString
    }
}