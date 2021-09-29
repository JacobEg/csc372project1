class Professor(name: String, idNumber: Int): Person(name) {
    val idNumber: Int
    val classList: MutableList<Int>

    init {
        this.idNumber = idNumber
        classList = mutableListOf<Int>()
    }
}