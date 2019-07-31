import java.util.ArrayList;
import java.util.List;

/**
 * 
 * JudgeMan
 * 勝敗管理を行うクラス
 *
 * @author S-cubism inc.
 * @since 2019.01
 */
public class JudgeMan
{
    checkAround checkAround = new checkAround();
    Reversi reversi = new Reversi();

    /**
     * ゲームが終了したかどうか判断
     * 
     * @param field 盤面
     * @param StoneType stoneType 石の種類
     * @return true:白黒両方orどちらか置けるところがある/false:両社置けるところがない
     */
    public boolean hasFinishedGame(int[][] field, StoneType stoneType1, StoneType stoneType2) {
        int a = nextCanPutNum(field, stoneType1);
        int b = nextCanPutNum(field, stoneType2);
        if (a == 0 && b == 0) {
            return false;
        }
        return true;
    }


    /**
     * 次に置ける場所の数を返す
     * 次に置く場所はターンごとに数が変わるので配列でなくListでもつ
     * 石のない場所全てにおけるかどうかのチェックを入れる
     * 
     * @param field 盤面
     * @param StoneType stoneType 石の種類
     * @return freeSpace:置くことのできる場所の数
     */
    public int nextCanPutNum(int[][] field, StoneType stoneType) {
        int freeSpace = 0;
        // 1つずつ置けるかどうか調べていく

        for (int vertical = 0; vertical < 8; vertical++) {
            for (int side = 0; side < 8; side++) {
                // 石がすでにあるかどうか(true:石がないので置ける場所/false:石があるので置けない場所)
                boolean existsStone = checkAround.checkExistence(vertical, side, field);
                int nowStoneNum = field[vertical][side];
                int count = checkAround.countSpace(field, vertical, side, stoneType);
                // inputを変換するメソッドを使っているのでvertical等は1を足す
                String input = String.valueOf(vertical + 1) + String.valueOf(side + 1);
                // checkが1以上ならひっくり返せるということ
                int check = reversi.isTurnOver(field, input, stoneType);
                // reversi.isTurnOverを通った時点で石の色が変わってしまうので再度上書き
                field[vertical][side] = nowStoneNum;
                if (count >= 1 && check > 0 && existsStone) {
                    freeSpace++;
                }
            }
        }
        return freeSpace;
    }

    /**
     * 勝敗決定
     * 
     * @param field 盤面(0:無し/1:白/2:黒)
     * @param StoneType stoneType 石の種類
     * @return freeSpace:置くことのできる場所の数
     */
    public void checkWinner(int[][] field) {
        int countBlack = 0;
        int countWhite = 0;
        for (int vertical = 0; vertical < 8; vertical++) {
            for (int side = 0; side < 8; side++) {
                switch (field[vertical][side]) {
                    case 0:
                        break;
                    case 1:
                        countWhite++;
                        break;
                    case 2:
                        countBlack++;
                        break;
                }
            }
        }
        if (countWhite > countBlack) {
            System.out.println("PLAYER WHITE IS WINNER!!");
        } else if (countBlack > countWhite) {
            System.out.println("PLAYER BLACK IS WINNER!!");
        } else if (countWhite == countBlack) {
            System.out.println("THIS GAME DRAW FOR BOTH PLAYER");
        }



    }


}
