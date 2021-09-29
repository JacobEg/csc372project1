class Student(name: String, idNumber: Int): Person(name) {
   val idNumber: Int
   val classList: MutableList<SchoolClass>

   init {
      this.idNumber = idNumber
      classList = mutableListOf<SchoolClass>()
   }

   public fun getID(): Int {
      return idNumber
   }

   public fun getClasses(): MutableList<SchoolClass> {
      return classList
   }

   public fun dropClass(classID: Int): SchoolClass? { // '?' necessary after return type to allow null to be returned
      for(c in classList) {
         if (c.getID() == classID)
            classList.remove(c)
         return c
      }
      return null
   }

   public override fun toString() : String {
      var retString = "ID: $idNumber\nName: $name\nClasses:\n"
      for (c in classList) {
         retString+="   ${c.getTitle()}\n"
      }
      return retString
   }

}