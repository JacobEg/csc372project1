/**
 * SchoolTest.kt
 *
 * Used to test the SchoolClass, Person, Professor, and Student Classes. May be modified to test different methods.
 */
fun main() {
    val jake = Student("Jake", 555111)
    val bob = Student("Bob", 124124)
    val susan = Student("Susan", 890123)
    val mary = Professor("Mary", 5687)
    val joe = Professor("Joe", 5698)
    val csc101 = SchoolClass(1261, "CSC 101", mary)
    val csc110 = SchoolClass(1262, "CSC 110", joe)
    jake.introduce() // inherited method from Person superclass
    csc101.addStudent(jake)
    csc101.addStudent(bob)
    csc110.addStudent(jake)
    csc110.addStudent(bob)
    csc110.addStudent(susan)
    println(bob.toString()) // Kotlin print method
    println(csc110.toString())
    csc110.removeStudent(bob.getID())
    println(bob.toString())
    println(csc110.toString())
}