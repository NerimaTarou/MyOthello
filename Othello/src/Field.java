import java.util.List;

/**
 * 
 * Field
 *
 * @author S-cubism inc.
 * @since 2019.01
 */
public class Field
{

    StoneMove stoneMove = new StoneMove();

    /**
     * 二次元の配列でフィールドを表現
     */
    int field[][];

    /**
     * フィールドの作成
     */
    public int[][] createField() {
        /**
         * 初期化した時点で中身は全て0
         */
        field = new int[8][8];
        /**
         * 初期配置設定
         */
        field[3][3] = 1;
        field[3][4] = 2;
        field[4][3] = 2;
        field[4][4] = 1;
        return field;
    }

    /**
     * 盤面の表示
     */
    public void showField(int field[][]) {
        for (int i = 0; i < 8; i++) {
            System.out.println(field[i][0] + " " + field[i][1] + " " + field[i][2] + " " + field[i][3] + " " +
                field[i][4] + " " + field[i][5] + " " + field[i][6] + " " + field[i][7] + " ");
        }
        System.out.println();
    }

    /**
     * 盤面を数字でなく記号で表示
     */
    public void showBoard(int field[][]) {
        String board[][] = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int check = field[i][j];
                if (check == 0) {
                    board[i][j] = "×";
                } else if (check == 1) {
                    board[i][j] = "○";
                } else if (check == 2) {
                    board[i][j] = "●";
                }
            }
        }
        System.out.println(" " + " 1 2 3 4 5 6 7 8");
        for (int i = 0; i < 8; i++) {
            System.out
                .println(i + 1 + " " + board[i][0] + " " + board[i][1] + " " + board[i][2] + " " + board[i][3] + " " +
                    board[i][4] + " " + board[i][5] + " " + board[i][6] + " " + board[i][7] + " ");
        }
    }

    /**
     * 実験用フィールドデータ作成
     * 
     */
    public int[][] createPlayedField() {
        field = new int[8][8];
        field[0][0] = 2;
        field[0][1] = 2;
        field[0][2] = 2;
        field[0][3] = 2;
        field[0][4] = 2;
        field[0][5] = 2;
        field[0][6] = 2;
        field[0][7] = 2;
        field[1][0] = 1;
        field[1][1] = 1;
        field[1][2] = 1;
        field[1][3] = 1;
        field[1][4] = 1;
        field[1][5] = 1;
        field[1][6] = 1;
        field[1][7] = 1;
        field[2][0] = 1;
        field[2][1] = 1;
        field[2][2] = 1;
        field[2][3] = 1;
        field[2][4] = 1;
        field[2][5] = 1;
        field[2][6] = 1;
        field[2][7] = 1;
        field[3][0] = 1;
        field[3][1] = 1;
        field[3][2] = 1;
        field[3][3] = 1;
        field[3][4] = 1;
        field[3][5] = 1;
        field[3][6] = 1;
        field[3][7] = 1;
        field[4][0] = 1;
        field[5][0] = 1;
        field[6][0] = 1;
        field[4][7] = 1;
        field[5][7] = 1;
        field[6][7] = 1;

        return field;
    }


}

