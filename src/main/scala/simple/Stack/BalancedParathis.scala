package simple.Stack


object BalancedParathis extends App {


  val s = "[]][{]{(({{)[})(}[[))}{}){[{]}{})()[{}]{{]]]){{}){({(}](({[{[{)]{)}}}({[)}}([{{]]({{".toCharArray
  val openBracket = Map("{" -> "}", "[" -> "]", "(" -> ")")
  findBalanceParathisis(s, openBracket)

  def findBalanceParathisis(s: Array[Char], openBracket: Map[String, String]): Unit = {
    val st = new java.util.Stack[String]();
    for (x <- s) {
      if (openBracket.contains(x.toString)) {
        st.push(x.toString)
      } else if (st.size != 0 && openBracket.get(st.peek()).get == x.toString) {
        st.pop()
      } else {
        println("NO")
        return
      }

    }
    if (st.size() == 0) {
      println("YES")
    } else {
      println("NO")
    }

  }
}