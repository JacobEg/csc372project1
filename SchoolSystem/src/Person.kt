abstract class Person(name: String) {
    protected val name: String

    init {
        this.name = name
    }

    fun getPersonName(): String {
        return this.name
    }

    protected fun introduce() {
        println("Hi, my name is $this.name")
    }
}