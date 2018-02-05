package simple


object LongestCommonPrefix extends App{

  val st = Array("abcxy","abchh","abcyhj")
  longestCommonPrefix(st)

  def longestCommonPrefix(strs: Array[String]): String = {
  if (strs==null || strs.length==0){
    return ""
  }
    var pre = strs(0)
    var i =0
    while(i<strs.length){
     val s= (strs(i).indexOf(pre))
      while(strs(i).indexOf(pre) != 0)
        pre = pre.substring(0,pre.length()-1)
      i=i+1

    }
    pre
  }

}
