//TODO: Add person superclass for professor and student, comments, toString methods, more methods

class SchoolClass (id: Int, title: String, prof: String) {
    private val classID: Int
    private var title: String
    private var professor: String
    private val roster : MutableList<Student>

    init {
        classID = id
        this.title = title
        professor = prof
        roster = mutableListOf<Student>()
    }

    fun getID(): Int {
        return classID
    }

    fun getTitle(): String {
        return title
    }

    fun getProfessor(): String {
        return professor
    }

    fun getRoster(): List<Student> {
        return roster
    }

    fun addStudent(student: Student) {
        roster.add(student)
        student.classList.add(classID)
    }

    fun removeStudent(id: Int) : Student? {
        for(student in roster) {
            if (student.idNumber == id)
                roster.remove(student)
                student.classList.remove(classID)
                return student
        }
        return null
    }

}