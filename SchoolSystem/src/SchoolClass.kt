//TODO: Add comments, toString methods, more methods

class SchoolClass (id: Int, title: String, prof: Professor) {
    private val classID: Int // use val keyword since classID should never change
    private var title: String
    private var professor: Professor
    private val roster : MutableList<Student> // must be a mutable list so students can be added/dropped from class

    init {
        classID = id
        this.title = title
        professor = prof
        roster = mutableListOf<Student>()
    }

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

    public fun addStudent(student: Student) {
        roster.add(student)
        student.classList.add(this)
    }

    public fun removeStudent(id: Int) : Student? {
        for(student in roster) {
            if (student.idNumber == id)
                roster.remove(student)
                student.dropClass(classID)
                return student
        }
        return null
    }

    public fun changeProfessor(newProf: Professor) : Professor {
        var oldProf: Professor = professor
        professor = newProf
        return oldProf
    }

    public override fun toString() : String {
        var retString = "Title: $title\nID: $classID\nProfessor: ${professor.getPersonName()}\nRoster:\n"
        for (student in roster) {
            retString+="    ${student.getID()}: ${student.getPersonName()}\n"
        }
        return retString
    }

}