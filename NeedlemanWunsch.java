public class NeedlemanWunsch {
    public static void main(String[] args) {
        String seq1 = "GATTACA";
        String seq2 = "GCATGCU";
        int match = 1;
        int mismatch = -1;
        int gap = -1;
        int[][] scoreMatrix = new int[seq1.length() + 1][seq2.length() + 1];
        for (int i = 0; i <= seq1.length(); i++) {
            scoreMatrix[i][0] = gap * i;
        }
        for (int j = 0; j <= seq2.length(); j++) {
            scoreMatrix[0][j] = gap * j;
        }
        for (int i = 1; i <= seq1.length(); i++) {
            for (int j = 1; j <= seq2.length(); j++) {
                int matchOrMismatch = seq1.charAt(i - 1) == seq2.charAt(j - 1) ? match : mismatch;
                int matchScore = scoreMatrix[i - 1][j - 1] + matchOrMismatch;
                int deleteScore = scoreMatrix[i - 1][j] + gap;
                int insertScore = scoreMatrix[i][j - 1] + gap;
                scoreMatrix[i][j] = Math.max(Math.max(matchScore, deleteScore), insertScore);
            }
        }
        StringBuilder alignmentSeq1 = new StringBuilder();
        StringBuilder alignmentSeq2 = new StringBuilder();
        int i = seq1.length();
        int j = seq2.length();
        while (i > 0 && j > 0) {
            if (scoreMatrix[i][j] == scoreMatrix[i - 1][j - 1] + (seq1.charAt(i - 1) == seq2.charAt(j - 1) ? match : mismatch)) {
                alignmentSeq1.append(seq1.charAt(i - 1));
                alignmentSeq2.append(seq2.charAt(j - 1));
                i--;
                j--;
            } else if (scoreMatrix[i][j] == scoreMatrix[i - 1][j] + gap) {
                alignmentSeq1.append(seq1.charAt(i - 1));
                alignmentSeq2.append("-");
                i--;
            } else {
                alignmentSeq1.append("-");
                alignmentSeq2.append(seq2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            alignmentSeq1.append(seq1.charAt(i - 1));
            alignmentSeq2.append("-");
            i--;
        }
        while (j > 0) {
            alignmentSeq1.append("-");
            alignmentSeq2.append(seq2.charAt(j - 1));
            j--;
        }
        System.out.println(alignmentSeq1.reverse().toString());
        System.out.println(alignmentSeq2.reverse().toString());
    }
}


/*

1. The program first defines the input sequences seq1 and seq2, as well as the scoring parameters match, mismatch, and gap.

2. It then initializes a 2D scoring matrix scoreMatrix with dimensions (seq1.length() + 1) x (seq2.length() + 1). 
The first row and column of the matrix are filled with gap penalties.

3. The program then fills in the rest of the matrix using a nested loop. 
For each cell (i, j) in the matrix, it calculates three possible scores: matchScore, deleteScore, and insertScore. 
These scores represent the maximum possible scores if the current cell is a match/mismatch, deletion, or insertion, respectively. 
The maximum of these three scores is then stored in the current cell.

4. Once the scoring matrix is filled, the program performs traceback to construct the optimal alignment. 
Starting from the bottom-right corner of the matrix, it moves diagonally if the current cell is a match/mismatch, up if it is a deletion, or left if it is an insertion. 
It continues moving until it reaches the top-left corner of the matrix.

5. During traceback, the program constructs two strings alignmentSeq1 and alignmentSeq2 representing the aligned sequences. 
If it moves diagonally, it appends the corresponding characters from both sequences to their respective aligned sequences. 
If it moves up or left, it appends a gap character to one of the aligned sequences and the corresponding character from the other sequence to its aligned sequence.

6. Finally, once traceback is complete, the program reverses both aligned sequences and prints them to standard output.

*/
