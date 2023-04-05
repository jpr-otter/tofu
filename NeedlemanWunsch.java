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
