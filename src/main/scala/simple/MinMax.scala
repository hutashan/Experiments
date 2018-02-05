package simple

import java.util
import java.util.Scanner

object MinMax {

  import java.util.Stack

  def main(args: Array[String]) {
    val scanner = new Scanner(System.in)
    val N = 7 // scanner.nextInt()
    val K = 3 //scanner.nextInt()
    //   val arr = new Array[Int](7)
    val i =0
    /* for (i <- 0 to N-1){
       arr(i)=scanner.nextInt()
     }*/

    val arr = Array(10,100,300,200,1000,20,30)
    val sortedArry = arr.toList.sorted
    var unfairness = Integer.MAX_VALUE
    println(N - K + 1)
    for (i <- 0 to (N - K )){
      println(i)
      println(sortedArry(i+K-1),sortedArry(i))
      if (sortedArry(i+K-1)-sortedArry(i)<unfairness)
        unfairness = sortedArry(i+K-1)-sortedArry(i)
    }

    println("unfairness" + unfairness)
  }


}