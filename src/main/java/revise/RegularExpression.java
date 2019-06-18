package revise;

public class RegularExpression {
    public static void main(String[] args) {
        String input = "aab";
        String pattern = "c*a*b";
        System.out.println(new RegularExpression().isMatch(input,pattern));

    }
    // non dymamic
    public boolean isMatchNon(String text, String pattern) {
        if(pattern.isEmpty()) return text.isEmpty();
        boolean first_half = (!text.isEmpty()) && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');
        if(pattern.length()>=2 && pattern.charAt(1)=='*'){
            boolean zeroOccuren = isMatch(text,pattern.substring(2));
            boolean nonZero = false;
            if(first_half){
                nonZero =  isMatch(text.substring(1),pattern);
            }
            return zeroOccuren || nonZero;
        } else{
            return first_half && isMatch(text.substring(1),pattern.substring(1));
        }


    }

    public boolean isMatch(String text, String pattern) {
        boolean[][] lookup = new boolean[text.length()+1][pattern.length()+1];
        lookup[0][0]=true;
        for(int i=1;i<lookup[0].length;i++){
            if(pattern.charAt(i-1)=='*')
            lookup[0][i]=lookup[0][i-2];
        }
        for(int i=1;i<lookup.length;i++){
            for(int j=1;j<lookup[0].length;j++){
                if(pattern.charAt(j-1)==text.charAt(i-1)|| pattern.charAt(j-1)=='.'){
                    lookup[i][j]=lookup[i-1][j-1];
                } else if( pattern.charAt(j-1)=='*'){
                    lookup[i][j]=lookup[i][j-2];
                    if(pattern.charAt(j-2)=='.' || pattern.charAt(j-2)==text.charAt(i-1)){
                        lookup[i][j]=lookup[i][j]||lookup[i-1][j];

                    }

                } else{
                    lookup[i][j]=false;
                }
            }
        }
        return lookup[text.length()][pattern.length()];
    }

}
