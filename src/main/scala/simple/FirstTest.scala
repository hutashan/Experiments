package simple

/**
  * Created by v708178 on 8/21/17.
  */
object FirstTest extends App {

  recursionFind(Array("main","test"),"testmain1","")

  def recursionFind(arr:Array[String],loginAtt:String,res:String){
   if (loginAtt.size==0){
     println(res)
   }
    var i=0
    for (i<-0 to loginAtt.length ){
    val prefix = loginAtt.substring(0,i)
    if (arr.contains(prefix)){
      recursionFind(arr,loginAtt.substring(i,loginAtt.length),res+" "+prefix)
    }
   }
    if (i==(loginAtt.length-1)) {
      println("WRONG PASSWORD")
    }
}

}
