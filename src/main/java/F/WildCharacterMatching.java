package F;

import java.util.Arrays;

public class WildCharacterMatching {
    public static void main(String[] args) {
        System.out.println(new WildCharacterMatching().isMatch("abced","a*d"));
    }
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] match = new boolean[n+1][m+1];

        for(int i = 0; i < n + 1; i++) {
            Arrays.fill(match[i], false);
        }
        match[0][0] = true;
        for (int j = 1; j <= m; j++)
            if (p.charAt(j - 1) == '*')
                match[0][j] = match[0][j - 1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
               if(p.charAt(j-1)=='*'){
                    match[i][j] = match[i][j - 1] ||  match[i-1 ][j];
                } else if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='?') {
                    match[i][j] = match[i - 1][j - 1];
                }else{
                    match[i][j]=false;
                }
            }
        }
        return match[n][m];
    }


    public boolean isMa (String str, String pattern)

        {
            int n = str.length();
            int m = pattern.length();
            // empty pattern can only match with
            // empty string
            if (m == 0)
                return (n == 0);

            // lookup table for storing results of
            // subproblems
            boolean[][] lookup = new boolean[n + 1][m + 1];

            // initailze lookup table to false
            for(int i = 0; i < n + 1; i++)
                Arrays.fill(lookup[i], false);


            // empty pattern can match with empty string
            lookup[0][0] = true;

            // Only '*' can match with empty string
            for (int j = 1; j <= m; j++)
                if (pattern.charAt(j - 1) == '*')
                    lookup[0][j] = lookup[0][j - 1];

            // fill the table in bottom-up fashion
            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= m; j++)
                {
                    // Two cases if we see a '*'
                    // a) We ignore '*'' character and move
                    //    to next  character in the pattern,
                    //     i.e., '*' indicates an empty sequence.
                    // b) '*' character matches with ith
                    //     character in input
                    if (pattern.charAt(j - 1) == '*')
                        lookup[i][j] = lookup[i][j - 1] ||
                                lookup[i - 1][j];

                        // Current characters are considered as
                        // matching in two cases
                        // (a) current character of pattern is '?'
                        // (b) characters actually match
                    else if (pattern.charAt(j - 1) == '?' ||
                            str.charAt(i - 1) == pattern.charAt(j - 1))
                        lookup[i][j] = lookup[i - 1][j - 1];

                        // If characters don't match
                    else lookup[i][j] = false;
                }
            }

            return lookup[n][m];

    }
}
