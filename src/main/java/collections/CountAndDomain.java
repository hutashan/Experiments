package collections;

import java.util.HashMap;
import java.util.Map;

public class CountAndDomain {

    public static void main(String[] args) {

        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "2,en.wikipedia.org",
                "1,es.wikipedia.org" };

        HashMap<String,Integer> h = getDomainCounts(counts);
        for (Map.Entry entry : h.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

    public static HashMap<String,Integer> getDomainCounts(String[] counts) {
        HashMap<String,Integer> hsmap = new HashMap<String,Integer>();
        for (int i=0;i<counts.length;i++){
            String[] count = counts[i].split(",");
            int countOfWord = Integer.parseInt(count[0]);
            String  domains = count[1];

            String[] splitDomain= domains.split("\\.");

            String sf = new String();
            for (int j=splitDomain.length-1;j>=0;j--){
                if (j==splitDomain.length-1){
                    sf =  splitDomain[j];
                } else
                sf =  splitDomain[j] +"."+sf ;
                int countOfSubDomain=0;
                if ( hsmap.containsKey(sf)){
                    //println(hsmap.get(sf));
                    countOfSubDomain =  countOfWord + hsmap.get(sf) ;
                    hsmap.put(sf,countOfSubDomain);
                    //sf = sf +".";
                } else {
                    hsmap.put(sf,countOfWord);
                   // sf = sf +".";
                }
                //   System.out.println("subdomain "+sf +" count "+countOfWord);
            }

        }

        return hsmap;

    }

}