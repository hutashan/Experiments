package G;

import java.util.*;
public class UniqueEmails {
    public static void main(String[] args) {
        String [] st = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(new UniqueEmails().numUniqueEmails(st));
    }
    public int numUniqueEmails(String[] emails) {
        if(emails==null || emails.length==0) return 0;
        Set<String> set = new HashSet<String>();
        for(String email : emails){
            String[] emailSplit = email.split("@");
            String local = emailSplit[0];
            //    StringBuilder sb = new StringBuilder();
            if(local.contains(".")){
                local = local.replace(".","");
            }
            if(local.contains("+")){
                int l = local.indexOf("+");
                local = local.substring(0,l);
            }
            String emailId = local+emailSplit[1];
            set.add(emailId);

        }
        return set.size();

    }
}

