package simple

object Solution1 {

  def main(args: Array[String]) {

  /*  val sc = new java.util.Scanner (System.in);
    var n = sc.nextInt();
    var unsorted = new Array[String](n);
    for(unsorted_i <- 0 to n-1) {
      unsorted(unsorted_i) = sc.next();
    }*/

    val unsorted: Array[String] = Array("31415926535897932384626433832795","1","3","6","5")

    val unsortedInt =  unsorted.sorted

    val sorted = unsortedInt.sorted
    for (unsorted_i <- 0 to unsortedInt.length-1){
      println(sorted(unsorted_i))
    }
  }
}