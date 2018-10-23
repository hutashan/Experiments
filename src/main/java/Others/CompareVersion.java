package Others;

public class CompareVersion {

    public static void main(String[] args) {
    String v1="1.0.0";
    String v2 ="2";
        System.out.println(new CompareVersion().compareVersion(v1,v2));
    }
    public int compareVersion(String version1, String version2) {
        if((version1==null && version1.equals("")) && version2!=null ) return -1;
        if((version2==null && version2.equals("")) && version1!=null ) return 1;
        String[] v1=version1.split("\\.");
        String[] v2=version2.split("\\.");
        int v1Len = v1.length;
        int v2Len = v2.length;
        int maxLen = Math.max(v1Len,v2Len);
        for(int i=0;i<maxLen;i++){
            int c1=0;
            int c2=0;
            if(i<v1Len)
                c1=Integer.parseInt(v1[i]);
            if(i<v2Len){
                c2=Integer.parseInt(v2[i]);
            }
            if(c1>c2){
                return 1;
            } else if(c1<c2){
                return -1;
            }

        }
        return 0;
    }
}
