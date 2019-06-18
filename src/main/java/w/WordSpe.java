package w;

public class WordSpe {
    public static void main(String[] args) {
       // System.out.println( "final result " +new WordSpe().wordCompare("Apple","PeaR","Apple"));
           System.out.println( "final result " +new WordSpe().wordCompare("EG","Ktp","JrF"));

    }
    public String wordCompare(String start ,String end ,String query){
        int startLength=start.length();
        int endLength=end.length();

        String returnResult ="";
        for(int i=0;i<query.length();i++) {
            if (i < startLength) {
                String result = compare(start.charAt(i), query.charAt(i));
                if (result.equals("Before")) {
                    System.out.println("Before");
                    return "Before";
                } else if (result.equals("Equal")) {
                    System.out.println("Equal");
                    if (i + 1 < startLength) {
                        returnResult = "Before";
                    } else {
                        returnResult = "Inside";
                    }
                } else {
                    System.out.println("Inside");
                    returnResult = "Inside";
                    break;
                }
            }
        }
        System.out.println("Calling after");
        if(returnResult.equals("Inside")) {
            for (int i = 0; i < query.length(); i++) {
                if (i < endLength) {
                    String result = compare(end.charAt(i), query.charAt(i));
                    if (result.equals("Before")) {
                        System.out.println("after Inside");
                        return "Inside";
                    } else if (result.equals("Equal")) {
                        System.out.println("after Equal");
                        if (i + 1 < endLength) {
                            returnResult = "After";
                        } else {
                            returnResult = "After";
                        }
                    } else {
                        System.out.println("after After");
                        returnResult = "After";
                        return "After";
                    }
                }
            }
        }




     return returnResult;
    }


    public String compare(Character o1, Character o2) {
        Character lo1= Character.toLowerCase(o1);
        Character lo2=  Character.toLowerCase(o2);

        if (lo1 > lo2) {
                System.out.println("lo1= " + lo1 + " 02 " + lo2 + " Before");
                return "Before";
            } else if(lo1==lo2){
                if(o1 > o2){
                    System.out.println("o1= " + o1 + " 02 " + o2 + " before");
                    return "Before";
                } else if(o1 < o2) {
                    System.out.println("o1= " + o1 + " 02 " + o2 + " before");
                    return "After";
                }
                    System.out.println("lo1= " + lo1 + " 02 " + lo2 + " equal");
                return "Equal";
            } else{
                System.out.println("lo1= " + lo1 + " 02 " + lo2 + " Inside");
                return "Inside";
            }



    }

}
