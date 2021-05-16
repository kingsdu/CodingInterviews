package DoExercise.JianzhiOffer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 */
public class Offer065_RectExist
{
    
    public static void main(String[] args)
    {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'F'}};
        String word = "ABCCED";
        System.out.println(exist3(board, word));
    }
    
    
    /**
     *
     * 学习大神的方法
     * 亮点在dfs中
     * 1、board[i][j] = ' ';防止重复走路
     * 2、board[i][j] = word[k];还原数组
     * 3、其他就是递归的条件限制
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist3(char[][] board, String word)
    {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[0].length; j++)
            {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }
    
    static boolean  dfs(char[][] board, char[] word, int i, int j, int k)
    {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        board[i][j] = ' ';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }
    
    
    
    /**
     *
     * 方法1：自己想的，把问题想的太简单了
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist1(char[][] board, String word)
    {
        int row = 0, col = 0;
        char[] chars = word.toCharArray();
        int i = 0;
        while ((row < board.length && col < board[0].length) && (i < chars.length))
        {
            System.out.println(board[row][col]);
            System.out.println(chars[i]);
            if (board[row][col] == chars[i])
            {
                col++;
                i++;
                continue;
            } else
            {
                col--;
                row++;
                if (board[row][col] == chars[i])
                {
                    i++;
                    continue;
                } else
                {
                    return false;
                }
            }
        }
        return true;
    }
    
    
    /**
     *
     * 方法2：自己想的，知道用递归，但是细节没把握好，看看上面的大神的思路，应该对你有提升
     *
     * @param board
     * @param word
     * @return
     */
    public static boolean exist2(char[][] board, String word)
    {
        int row = 0, col = 0, x = 0;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
        
        }
        return true;
    }
    
    public static boolean setWay(int i, int j, int x, char chars[], char[][] board)
    {
        if (x >= chars.length)
        {
            return true;
        } else
        {
            if (board[i][j] == chars[x])
            {
                x++;
                return true;
            } else
            {
                if (i < board.length && j < board[0].length)
                {
                    if (setWay(i + 1, j, x, chars, board))
                    {
                    
                    } else if (setWay(i, j + 1, x, chars, board))
                    {
                    
                    } else if (setWay(i - 1, x, j, chars, board))
                    {
                    
                    } else if (setWay(i, j - 1, x, chars, board))
                    {
                    
                    } else
                    {
                        return false;
                    }
                } else
                {
                    return false;
                }
            }
        }
        return false;
    }
    
}
