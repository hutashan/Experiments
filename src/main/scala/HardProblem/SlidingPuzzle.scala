package HardProblem

import java.util
import java.util.Arrays

object SlidingPuzzle extends App{
  val v = Array(Array(1,2,3),Array(5,4,0))

  println(slidingPuzzle(v))

  def slidingPuzzle(board:Array[Array[Int]]):Int= {

    var s = util.Arrays.deepToString(board.asInstanceOf[Array[AnyRef]]).replaceAll("\\[|\\]|,|\\s", "")
    val result = "123450"
    val seen = new util.HashSet[String]
    seen.add(s)
    val qu = new util.LinkedList(Arrays.asList(s))
    var count = 0
    while (!qu.isEmpty) {
      for (i <- 0 to qu.size()-1) {

        val str = qu.poll()
        if (str.equals(result)){
          return count
        }
        val idx = str.indexOf("0")
        val potentialMove = Array(1, -1, 3, -3)
        for (j <- 0 to potentialMove.length-1) {
          val nextMove = idx + potentialMove(j)
          var fl = 0
          if (nextMove < 0 || nextMove > 5 || idx == 2 && potentialMove == 3 || idx == 3 && potentialMove == 2) {
            fl = 1
          }
          if (fl == 0) {
            val ch = str.toCharArray
            val temp = ch(nextMove)
            ch(nextMove) = ch(idx)
            ch(idx) = temp
            val s = String.valueOf(ch)
            if (seen.add(s)) {
              qu.offer(s)
              //Avoid duplicate.}
            }
          }
        }
        count += 1
      }


    }
    -1
  }
}
