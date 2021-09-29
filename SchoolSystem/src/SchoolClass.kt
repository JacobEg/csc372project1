/**
 * SchoolClass.kt
 *
 * Used to represent a class at a school. Has attributes for the ID number of the class, the class title, professor,
 * and a class roster represented by a list of Student objects.
 */

// each parameter for the class constructor is typed
class SchoolClass (id: Int, title: String, prof: Professor) {
    private val classID: Int // use val keyword since classID should never change
    private var title: String // use var keyword since title could theoretically change
    private var professor: Professor
    private val roster : MutableList<Student> // must be a mutable list so students can be added/dropped from class

    // Constructor in Kotlin
    init {
        classID = id
        this.title = title //'this' keyword used as in Java to refer to current object
        professor = prof
        roster = mutableListOf<Student>() // this is how mutable lists are created in Kotlin
    }

    // getter methods
    public fun getID(): Int {
        return classID
    }
    public fun getTitle(): String {
        return title
    }
    public fun getProfessor(): Professor {
        return professor
    }
    public fun getRoster(): List<Student> {
        return roster
    }

    // setter method
    public fun setTitle(newTitle: String) {
        title = newTitle
    }

    /**
     * Adds a student to the roster
     *
     * student - the Student object being added to the roster list
     */
    public fun addStudent(student: Student) {
        roster.add(student) // list add method in Kotlin
        student.addClass(this)
    }

    /**
     * Removes a student from the class roster
     *
     * id - The ID number of the student being removed
     * Returns the Student object being removed, null if not found
     */
    // null is a unique type in Kotlin, so in order to return null we have to add '?' to the return type
    public fun removeStudent(id: Int) : Student? { //Student? ^^
        for(student in roster) { // Kotlin's for-each loop, very similar to Python's
            // find the correct student in the roster list and remove/return them
            if (student.getID() == id) {
                roster.remove(student) // list remove method in Kotlin
                student.dropClass(classID)
                return student
            }
        }
        return null
    }

    /**
     * Replaces the current professor with another one. Assumes a class can only have one professor.
     *
     * newProf - The new Professor object
     * Returns the old Professor object
     */
    public fun changeProfessor(newProf: Professor) : Professor {
        val oldProf: Professor = professor
        professor = newProf
        newProf.addClass(this)
        oldProf.removeClass(this)
        return oldProf
    }

    // toString
    //'$' used in strings to insert variable values in Kotlin
    public override fun toString() : String {
        var retString = "Title: $title\nID: $classID\nProfessor: ${professor.getPersonName()} (${professor.getID()})\nRoster:\n"
        for (student in roster) {
            retString+="    ${student.getID()}: ${student.getPersonName()}\n"
        }
        return retString
    }

}