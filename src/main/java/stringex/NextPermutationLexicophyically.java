package stringex;


import java.util.Arrays;

public class NextPermutationLexicophyically {
    public static void main(String arg[]){
        StringComparable s1 =new StringComparable("A");
        StringComparable s2 =new StringComparable("C");
        StringComparable s3 =new StringComparable("B");
        StringComparable s4 =new StringComparable("D");
        StringComparable s5 =new StringComparable("G");
        StringComparable[] s = new StringComparable[5];
        s[0]=s1;
        s[1]=s2;
        s[2]=s3;
        s[3]=s4;
        s[4]=s5;
        printPermutations(s);
    }


    private static void printPermutations( Comparable[] c ) {
        System.out.println( Arrays.toString( c ) );
        while ( ( c = nextPermutation( c ) ) != null ) {
            System.out.println( Arrays.toString( c ) );
        }
    }
    private static Comparable[] nextPermutation( final Comparable[] c ) {
        // 1. finds the largest k, that c[k] < c[k+1]
        int first = getFirst( c );
        if ( first == -1 ) return null; // no greater permutation
        // 2. find last index toSwap, that c[k] < c[toSwap]
        int toSwap = c.length - 1;
        while ( c[ first ].compareTo( c[ toSwap ] ) >= 0 )
            --toSwap;
        // 3. swap elements with indexes first and last
        swap( c, first++, toSwap );
        // 4. reverse sequence from k+1 to n (inclusive)
        toSwap = c.length - 1;
        while ( first < toSwap )
            swap( c, first++, toSwap-- );
        return c;
    }
    private static int getFirst( final Comparable[] c ) {
        for ( int i = c.length - 2; i >= 0; --i )
            if ( c[ i ].compareTo( c[ i + 1 ] ) < 0 )
                return i;
        return -1;
    }
    private static void swap( final Comparable[] c, final int i, final int j ) {
        final Comparable tmp = c[ i ];
        c[ i ] = c[ j ];
        c[ j ] = tmp;
    }
}
