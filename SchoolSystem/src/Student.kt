/**
 * Student.kt
 *
 * Class representing a University student. Inherits from Person. Has fields for the student's ID number and list of
 * classes that they are enrolled in.
 */
class Student(name: String, idNumber: Int): Person(name) {
   private val idNumber: Int
   private val classList: MutableList<SchoolClass>

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
    * Removes a class from the student's classlist and returns it
    *
    * SchoolClass - the SchoolClass to be removed
    * Returns the removed SchoolClass
    */
   public fun dropClass(classID: Int): SchoolClass? { // '?' necessary after return type to allow null to be returned
      for(c in classList) {
         if (c.getID() == classID)
            classList.remove(c)
         return c
      }
      return null
   }

   /**
    * Allows SchoolClass to be added to the Student's classList
    *
    * c - The SchoolClass object being added to the Student's classlist
    */
   public fun addClass(c : SchoolClass) {
      for(o in classList) {
         if (o.getID() == c.getID())
            return
      }
      classList.add(c)
   }

   /**
    * Since the superclass has an abstract getRole method, this class must implement it, in this case returning
    * the String "Student"
    */
   public override fun getRole(): String {
      return "Student"
   }

   // toString
   //'$' used in strings to insert variable values in Kotlin
   public override fun toString() : String {
      var retString = "ID: $idNumber\nStudent Name: $name\nClasses:\n"
      for (c in classList) {
         retString+="   ${c.getTitle()}\n"
      }
      return retString
   }

}