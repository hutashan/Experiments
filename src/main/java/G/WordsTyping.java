package G;

public class WordsTyping {

    public static void main(String[] args) {
        int rows = 4, cols = 5;
        String[] sentence = {"I", "had", "apple", "pie"};
        String s = String.join(" ",sentence)+" ";
        System.out.println(s);
        System.out.println(new WordsTyping().wordsTyping(sentence,rows,cols));

    }


    public int wordsTyping(String[] sentence, int rows, int cols) {

        String jSentence = String.join(" ", sentence) + " ";
        int nextRowStart = 0;
        for(int row = 0; row < rows; row++)
        {
            // Optimistically include everything from the new row and we'll strip it from the end
            // to see how much we can fit
            nextRowStart += cols;
            int s = nextRowStart % jSentence.length();
            char c = jSentence.charAt(s);

            // Shrink till we find the last new space (end of a word)
            while(nextRowStart > 0 && jSentence.charAt(nextRowStart % jSentence.length()) != ' ') {
                nextRowStart--;
            }

            // We have filled up the current row, let's move on to the next row, start with the next word
            // after the space
            nextRowStart++;
        }

        // We have found all the characters we can fill
        return (nextRowStart)/jSentence.length();
    }

    public int wordsTyping1(String[] sentence, int rows, int cols) {

        int ans=0;
        int currentIndex=0;
        for(int i=0;i<rows;i++){
            int leftCol = cols;
            for(;currentIndex<sentence.length;){
                int nextLength = sentence[currentIndex].length();
                if(leftCol>=nextLength){
                    leftCol=leftCol-(nextLength+1);
                    currentIndex++;
                    if(currentIndex==sentence.length ){
                        currentIndex=0;
                        ans=ans+1;
                    }
                    if(leftCol==0 || leftCol==-1 ){
                        break;
                    }

                } else{
                    break;
                }
            }
        }
    return ans;
    }
}
