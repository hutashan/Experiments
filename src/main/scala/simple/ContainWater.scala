package simple

/**
  * Created by v708178 on 8/25/17.
  */
object ContainWater extends App{
  maxArea(Array(2,3,5,6,3,5))
  maxArea(Array(2,1,5,6,3,5))


  def maxArea(height:Array[Int]):Int={




    val fromLeft : Array[Int]= new Array(height.length)
    val fromRight : Array[Int]= new Array(height.length)
    var maxHeight=height(0)
    var i=0;
    for (i <- 0 to height.length-1){
      if (maxHeight<height(i)){
        maxHeight=height(i)
      }
      fromLeft(i)=maxHeight-height(i)
    }
    maxHeight=height(height.length-1 )
    for (i <- height.length-1 to 0 by -1){
      if (maxHeight<height(i)){
        maxHeight=height(i)
      }
      fromRight(i)=maxHeight-height(i)
    }
    var totalSum=0
    for (i <- 0 to height.length-1){
      totalSum = totalSum + Math.min(fromRight(i),fromLeft(i))
    }
    print(totalSum)
    totalSum
  }
}
