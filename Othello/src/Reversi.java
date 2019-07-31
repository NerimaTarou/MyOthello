import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Reversi
 * 石をひっくり返すメソッドをもつクラス
 *
 * @author S-cubism inc.
 * @since 2019.01
 */
public class Reversi
{

    StoneMove stoneMove = new StoneMove();
    checkAround checkAround = new checkAround();

    /**
     * 右側の石をひっくり返す
     * 右に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverRight(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkRight(field, vertical, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        // side+count+1<7 盤の端に余白がきちんとあるか確認
        if (count > 0 && side + count + 1 <= 7 && field[vertical][side + count + 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical][side + j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverRightCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkRight(field, vertical, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && side + count + 1 <= 7 && field[vertical][side + count + 1] != 0) {
            check = 1;
        }
        return check;
    }

    /**
     * 左側の石をひっくり返す
     * 左に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverLeft(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkLeft(field, vertical, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && side - count - 1 >= 0 && field[vertical][side - count - 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical][side - j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverLeftCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkLeft(field, vertical, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && side - count - 1 >= 0 && field[vertical][side - count - 1] != 0) {
            check = 1;
        }
        return check;
    }


    /**
     * 上の石をひっくり返す
     * 上に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverUp(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkUp(field, vertical - i, side, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && field[vertical - count - 1][side] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical - j][side] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverUpCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkUp(field, vertical - i, side, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && field[vertical - count - 1][side] != 0) {
            check = 1;
        }
        return check;
    }


    /**
     * 下側の石をひっくり返す
     * 下に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverDown(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDown(field, vertical + i, side, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && field[vertical + count + 1][side] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical + j][side] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverDownCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDown(field, vertical + i, side, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && field[vertical + count + 1][side] != 0) {
            check = 1;
        }
        return check;
    }


    /**
     * 右斜め上の石をひっくり返す
     * 右斜め上に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverDiagUpRight(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagUpRight(field, vertical - i, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && side + count + 1 <= 7
            && field[vertical - count - 1][side + count + 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical - j][side + j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverDiagUpRightCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagUpRight(field, vertical - i, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && side + count + 1 <= 7
            && field[vertical - count - 1][side + count + 1] != 0) {
            check = 1;
        }
        return check;
    }

    /**
     * 右斜め下の石をひっくり返す
     * 右斜め下に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverDiagDownRight(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagDownRight(field, vertical + i, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && side + count + 1 <= 7
            && field[vertical + count + 1][side + count + 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical + j][side + j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverDiagDownRightCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagDownRight(field, vertical + i, side + i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && side + count + 1 <= 7
            && field[vertical + count + 1][side + count + 1] != 0) {
            check = 1;
        }
        return check;
    }

    /**
     * 左斜め上の石をひっくり返す
     * 左斜め上に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverDiagUpLeft(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagUpLeft(field, vertical - i, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && side - count - 1 >= 0
            && field[vertical - count - 1][side - count - 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical - j][side - j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverDiagUpLeftCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagUpLeft(field, vertical - i, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical - count - 1 >= 0 && side - count - 1 >= 0
            && field[vertical - count - 1][side - count - 1] != 0) {
            check = 1;
        }
        return check;
    }

    /**
     * 左斜め下の石をひっくり返す
     * 左斜め下に違う色の石があり、かつ空きマスじゃない場合に
     * 次の同じ色の石が来る場合までカウントを行い、
     * その数だけ石をひっくり返す
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     */
    public int[][] turnOverDiagDownLeft(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagDownLeft(field, vertical + i, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && side - count - 1 >= 0
            && field[vertical + count + 1][side - count - 1] != 0) {
            field[vertical][side] = stoneNumber;
            for (int j = 1; j <= count; j++) {
                field[vertical + j][side - j] = stoneNumber;
            }
            field[vertical][side] = checkAround.checkStoneType(stoneType);
        } else {
            field[vertical][side] = 0;
        }
        return field;
    }

    /**
     * 上記のメソッドによりひっくり返すものが存在するか調べる
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @param stoneType enum
     * @return check 0:存在しない1.存在する
     */
    public int turnOverDiagDownLeftCheck(int field[][], String input, StoneType stoneType) {
        List<Integer> numbers = stoneMove.convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        int check = 0;
        int count = 0;
        int stoneNumber = checkAround.checkStoneType(stoneType);
        field[vertical][side] = stoneNumber;
        for (int i = 0; i < 7; i++) {
            int existsStone = checkAround.checkDiagDownLeft(field, vertical + i, side - i, stoneType);
            if (existsStone == 1 && field[vertical][side] != 0) {
                count++;
            } else {
                break;
            }
        }
        if (count > 0 && vertical + count + 1 <= 7 && side - count - 1 >= 0
            && field[vertical + count + 1][side - count - 1] != 0) {
            check = 1;
        }
        return check;
    }



    /**
     * ひっくり返すメソッドの統合
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     */
    public int[][] turnOver(int field[][], String input, StoneType stoneType) {
        turnOverRight(field, input, stoneType);
        turnOverLeft(field, input, stoneType);
        turnOverUp(field, input, stoneType);
        turnOverDown(field, input, stoneType);
        turnOverDiagUpRight(field, input, stoneType);
        turnOverDiagDownRight(field, input, stoneType);
        turnOverDiagUpLeft(field, input, stoneType);
        turnOverDiagDownLeft(field, input, stoneType);
        return field;
    }

    /**
     * ひっくり返すメソッドチェックの統合
     * checkが1以上ならひっくり返すことができる場所であるといえる
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     */
    public int isTurnOver(int field[][], String input, StoneType stoneType) {
        int check = turnOverRightCheck(field, input, stoneType) +
            turnOverLeftCheck(field, input, stoneType) +
            turnOverUpCheck(field, input, stoneType) +
            turnOverDownCheck(field, input, stoneType) +
            turnOverDiagUpRightCheck(field, input, stoneType) +
            turnOverDiagDownRightCheck(field, input, stoneType) +
            turnOverDiagUpLeftCheck(field, input, stoneType) +
            turnOverDiagDownLeftCheck(field, input, stoneType);
        return check;
    }

}
