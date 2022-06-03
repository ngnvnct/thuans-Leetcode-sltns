import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class word_search {
    public boolean wordSearch(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, int i, int j, int wordIndex, String word) {
        if (wordIndex == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || board[i][j] != word.charAt(wordIndex)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, i, j+1, wordIndex+1, word) ||
        dfs(board, i-1, j, wordIndex+1, word) || 
        dfs(board, i+1, j, wordIndex+1, word) ||
        dfs(board, i, j-1, wordIndex+1, word);
        board[i][j] = temp;
        return found;
    }

    @Test
    public void testWordSearch() {
        char[][] boardOne = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}; 
        String wordOne = "ABCCED";
        String wordTwo = "SEE";
        String wordThree= "ABCB";
        assertEquals(true, wordSearch(boardOne, wordOne));
        assertEquals(true, wordSearch(boardOne, wordTwo));
        assertEquals(false, wordSearch(boardOne, wordThree)); 
    }
}

/*
https://leetcode.com/problems/word-search/
Explanation

This is a famous backtracking problem. If we see the first word in the word bank, we recursively call dfs on it.
A B C E
S F C S
A D E E
Word = ABCCED

It see A, it calls DFS, now A will go all 4 direction, and it found B, go all three directions, see C.....

Time: O(N * 3^L) where N is the number of cells and L is the number of length to be match, the 3 is the direction to explore, it is 4 direction but we don't need to revisit
Space: O(L) where L is the number of length
*/