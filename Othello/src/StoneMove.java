import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


/**
 * 
 * StoneMove
 * 石の動きを表すクラス
 *
 * @author S-cubism inc.
 * @since 2019.01
 */
public class StoneMove
{

    /**
     * 特定の数字を入力した場合に石を置く
     *
     * @param int[][] field 盤面
     * @param StoneType stoneType 石の種類
     * @param String input 入力された文字列
     * @return int[][] field メソッド実行後の盤面
     */
    public int[][] putStone(int[][] field, StoneType stoneType, String input) {
        List<Integer> numbers = convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        switch (stoneType) {
            case WHITE:
                field[vertical][side] = 1;
                return (field);
            case BLACK:
                field[vertical][side] = 2;
                return (field);
        }
        return field;
    }

    /**
     * 入力された文字列を数字２つに変換
     * 
     * @param String input 入力された文字列
     * @return List<Integer> ２つの数字が入った配列
     */
    public List<Integer> convertNum(String input) {
        List<Integer> numbers = new ArrayList();
        String[] strArray = input.split("");
        for (String item : strArray) {
            numbers.add(Integer.parseInt(item) - 1);
        }
        return numbers;
    }

    /**
     * 入力された文字が正しいかチェック(漢字数字含め)
     * 
     * @param String input 入力された文字列
     * @return true 1~8の数字の場合/false それ以外の場合
     */
    public boolean checkInput(String input) {
        String[] strArray = input.split("");
        // strArrayの長さが３以上なら不適
        if (strArray.length != 2) {
            return false;
        }
        // strArrayが1から8の数字でなければ不適
        long count = 0;
        Stream<String> stream = Stream.of(strArray);
        count = stream.filter(c -> c.matches("^[1-8]+$")).count();
        boolean result = (count > 0) ? true : false;
        return result;
    }

    /**
     * 指定した盤面が0のままかどうかの判断
     *
     * @param field 盤面
     * @param String input 入力された文字列
     * @return true:0/falseそれ以外の場合
     */
    public boolean checkIfZero(int field[][], String input) {
        List<Integer> numbers = convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        boolean result = false;
        if (field[vertical][side] == 0) {
            result = true;
        }
        return result;
    }

    /**
     * 最新の打った場所の石の色の数字を表示
     * 
     * @param field 盤面
     * @param input 盤面の縦列、横列の文字列
     * @return
     */
    public int nowStoneType(int field[][], String input) {
        List<Integer> numbers = convertNum(input);
        int vertical = numbers.get(0);
        int side = numbers.get(1);
        return field[vertical][side];
    }
}
