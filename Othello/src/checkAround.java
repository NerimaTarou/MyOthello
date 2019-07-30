
public class checkAround
{

    public checkAround() {}

    /**
     * 右に違う色の石があるのかを判断
     * 
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkRight(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (b + 1 <= 7) {
            result = (point != field[a][b + 1] && field[a][b + 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 左に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkLeft(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (b - 1 >= 0) {
            result = (point != field[a][b - 1] && field[a][b - 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 上に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkUp(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a - 1 >= 0) {
            result = (point != field[a - 1][b] && field[a - 1][b] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 下に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkDown(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a + 1 <= 7) {
            result = (point != field[a + 1][b] && field[a + 1][b] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 右斜め上に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkDiagUpRight(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a - 1 >= 0 && b + 1 <= 7) {
            result = (point != field[a - 1][b + 1] && field[a - 1][b + 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 右斜め下に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkDiagDownRight(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a + 1 <= 7 && b + 1 <= 7) {
            result = (point != field[a + 1][b + 1] && field[a + 1][b + 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 左斜め上に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkDiagUpLeft(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a - 1 >= 0 && b - 1 >= 0) {
            result = (point != field[a - 1][b - 1] && field[a - 1][b - 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }

    /**
     * 左斜め下に違う色の石があるのかを判断
     * 
     * @param field 盤面
     * @param a 盤面の縦列
     * @param b 盤面の横列
     * @param stoneType enum
     * @return result (1:右に違う色の石がある/0:石がない)
     */
    public int checkDiagDownLeft(int field[][], int a, int b, StoneType stoneType) {
        int point = checkStoneType(stoneType);
        int existsStone = 0;
        boolean result = false;
        if (a + 1 <= 7 && b - 1 >= 0) {
            result = (point != field[a + 1][b - 1] && field[a + 1][b - 1] != 0) ? true : false;
        }
        if (result == true) {
            existsStone = 1;
        }
        return existsStone;
    }
    
    /**
     * 石を置ける場所全てチェックし、そのtrueの数を返す
     * 
     * @param 
     * @return count(trueの数)
     */
    public int countSpace(int field[][], int a, int b, StoneType stoneType) {
        int count = 0;
        if(checkExistence(a, b,field)) {
        count = checkRight(field,a,b,stoneType) +
                checkLeft(field,a,b,stoneType)+
                checkUp(field,a,b,stoneType)+
                checkDown(field,a,b,stoneType)+
                checkDiagUpRight(field,a,b,stoneType)+
                checkDiagUpLeft(field,a,b,stoneType)+
                checkDiagDownRight(field,a,b,stoneType)+
                checkDiagDownLeft(field,a,b,stoneType);
        }
        return count;
    }

    /**
     * StoneTypeからStoneTypeの番号を確認
     * 
     * @param　stoneType StoneTypeのenum
     * @return 盤面の数字(0.なし/1.白/２．黒)
     */
    public int checkStoneType(StoneType stoneType) {
        int point = 0;
        if (stoneType == StoneType.WHITE) {
            point = 1;
        } else if (stoneType == StoneType.BLACK) {
            point = 2;
        }
        return point;
    }

    /**
     * StoneTypeの番号からStoneTypeの名前を取得
     * 
     * @param a 盤面の数字
     * @return StoneTypeのenum
     */
    public StoneType checkStoneName(int a) {
        if (a == 1) {
            return StoneType.WHITE;
        } else if (a == 2) {
            return StoneType.BLACK;
        }
        return StoneType.NONE;
    }
    
    /**
     * 石を置く場所に既に石があるかどうか判断
     * 
     * @param a 盤面の縦列
     * @param b 　盤面の横列
     * @param field 盤面
     * @return boolean(true:置ける/false:置けない)
     */
    public boolean checkExistence(int a, int b, int[][] field) {
        int check = field[a][b];
        boolean result = (check == 0) ? true : false;
        return result;
    }
}
