package ha.library.util

object string {

  implicit class ClassHelper(str: String) {

    /**
      * Deletes the character at the specified index from the string
      *
      * @param idx the index where the character is to be deleted
      * @return a new string with same characters except the one being deleted.
      */
    def deleteAt(idx: Int): String = {
      assert(idx >= 0 && idx < str.length)
      if (idx == 0) str.substring(1)
      else if (idx == str.length - 1) str.substring(0, idx)
      else str.substring(0, idx) + str.substring(idx + 1)
    }
  }

}
