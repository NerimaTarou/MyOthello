import java.util.List;
import java.util.Scanner;

/**
 * 
 * Main
 *
 * @author S-cubism inc.
 * @since 2019.01
 */
public class Main
{

    public static void main(String[] args) {
        /**
         * 盤面を作成し、出力する
         */
        Field field = new Field();
        int board[][] = field.createField();
        field.showField(board);
        field.showBoard(board);
        StoneMove stoneMove = new StoneMove();
        checkAround checkAround = new checkAround();
        Reversi reversi = new Reversi();
        JudgeMan judgeMan = new JudgeMan();
        int turn = 0;
        boolean isTurnContinue = true;

        /**
         * 指定の場所に石を置く
         * 
         * 
         */
        // お互いに置く場所がなければ試合終了
        while (judgeMan.hasFinishedGame(board, StoneType.BLACK, StoneType.WHITE)) {
            /**
             * 先行：黒
             * turn が偶数時にターン権を得る
             */
            while (turn % 2 == 0) {
                // 黒の置く場所がなければターン終了
                if (judgeMan.nextCanPutNum(board, StoneType.BLACK) == 0) {
                    System.out.println("PLAYER BLACK => You Cannot Put Stone Anywhere");
                    turn++;
                    break;
                }
                System.out.println("PLAYER BLACK => Please input the place you want to put stone");
                // inputを変数に格納
                Scanner sc1 = new Scanner(System.in);
                String input = sc1.nextLine();
                // inputが正しい文字列かどうか判断
                if (stoneMove.checkInput(input) == false) {
                    System.out.println("<< Your Input Is Incorrect >>");
                    break;
                }
                List<Integer> numbers = stoneMove.convertNum(input);
                int vertical = numbers.get(0);
                int side = numbers.get(1);
                int nowStoneNum = board[vertical][side];
                // input に対して周囲に違う色の石があるかどうかカウント
                int count = checkAround.countSpace(board, vertical, side, StoneType.BLACK);
                System.out.println(checkAround.countSpace(board, vertical, side, StoneType.BLACK));
                // reversi.isTurnOver(board, input, StoneType.BLACK) ひっくり返せるものがあればカウント
                if (count >= 1 && reversi.isTurnOver(board, input, StoneType.BLACK) > 0) {
                    reversi.turnOver(board, input, StoneType.BLACK);
                    board[vertical][side] = 2;
                    turn++;
                } else {
                    // stoneを置いた後にひっくり返す等の判断が入るので石を置く前の状態に初期化
                    board[vertical][side] = nowStoneNum;
                    System.out.println("<< You cannot put stone here >>");
                }
                field.showField(board);
                field.showBoard(board);
            }

            /**
             * 後攻：白
             * turn が奇数時にターン権を得る
             */
            // お互いに置く場所がなければ試合終了
            if (judgeMan.hasFinishedGame(board, StoneType.BLACK, StoneType.WHITE)) {
            } else {
                break;
            }
            while (turn % 2 != 0) {
                // 白の置く場所がなければターン終了
                if (judgeMan.nextCanPutNum(board, StoneType.WHITE) == 0) {
                    System.out.println("PLAYER WHITE => You Cannot Put Stone Anywhere");
                    turn++;
                    break;
                }
                System.out.println("PLAYER WHITE => Please input the place you want to put stone");
                Scanner sc1 = new Scanner(System.in);
                String input = sc1.nextLine();
                // inputが正しい文字列かどうか判断
                if (stoneMove.checkInput(input) == false) {
                    System.out.println("<< Your Input Is Incorrect >>");
                    break;
                }
                List<Integer> numbers = stoneMove.convertNum(input);
                int vertical = numbers.get(0);
                int side = numbers.get(1);
                int nowStoneNum = board[vertical][side];
                int count = checkAround.countSpace(board, vertical, side, StoneType.WHITE);
                System.out.println(reversi.isTurnOver(board, input, StoneType.WHITE));
                if (count >= 1 && reversi.isTurnOver(board, input, StoneType.WHITE) > 0) {
                    reversi.turnOver(board, input, StoneType.WHITE);
                    board[vertical][side] = 1;
                    turn++;
                } else {
                    // stoneを置いた後にひっくり返す等の判断が入るので石を置く前の状態に初期化
                    board[vertical][side] = nowStoneNum;
                    System.out.println("<< You cannot put stone here >>");
                }
                field.showField(board);
                field.showBoard(board);
            }
        }
        System.out.println("Finish");
    }

}
