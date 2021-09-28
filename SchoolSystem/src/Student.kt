class Student(
   var name: String,
   val idNumber: Int,
   val classList: MutableList<Int>
) {
   fun getSName(): String {
      return name
   }

   fun getID(): Int {
      return idNumber
   }

   fun getClasses(): MutableList<Int> {
      return classList
   }

}