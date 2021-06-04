package DoExercise.JianzhiOffer;

/**
 * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class TestDay
{
    
    
    public static void main(String[] args)
    {

    }
    
    
    public boolean exist(char[][] board, String word)
    {
        return false;
    }
    
    public boolean dfs(char[][] board, char[] word, int i, int j, int k)
    {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length || board[i][j] != word[k]) return false;
        if (word.length - 1 == k) return true;
        board[i][j] = ' ';
        boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1) ||
                dfs(board,word,i,j+1,k+1) || dfs(board,word,i,j-1,k+1);
        board[i][j] = word[k];
        return res;
    }
    
}
