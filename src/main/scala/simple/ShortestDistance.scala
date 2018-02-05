package simple

object ShortestDistance extends App{

  val st ="abcde".toCharArray
  val c1='b'
  val c2= 'e'
  var i=0
  var p1 = -1
  var p2 = -1
  var longestDist = Integer.MAX_VALUE
   for(i <- 0 to st.length-1){
    if(st(i) ==c1){
      p1=i
    }
     if(st(i) ==c2){
       p2=i
     }
     if (p1 != -1 && p2 != -1)
     longestDist = Math.min(longestDist,p2-p1)
  }
  println(longestDist)

}
