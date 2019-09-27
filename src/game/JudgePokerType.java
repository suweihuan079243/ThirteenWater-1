package game;

import java.util.ArrayList;
import java.util.HashMap;

public class JudgePokerType {
    /**
     * a1的值为手牌中重复一次(单张牌)的牌，a2的值为手牌中重复二次(对牌)的牌，
     * a3的值为手牌中重复三次(三张)的牌，a4的值为手牌中重复四次(炸弹)的牌。
     */
    private StringBuffer a1 = new StringBuffer();
    private StringBuffer a2 = new StringBuffer();
    private StringBuffer a3 = new StringBuffer();
    private StringBuffer a4 = new StringBuffer();


    public void countPoker(ArrayList<String> handPoker)
    {
        //把花色去掉
        ArrayList<String> numList = new ArrayList<>();
        for(String str : handPoker){
            str = str.substring(1);
            numList.add(str);
        }
        int index = 0;
        while (true) {
            if ( index < numList.size() - 3 && numList.get(index).equals(numList.get(index + 3)) ) {
                a4.append(numList.get(index));
                index = index + 4;
            } else if (index < numList.size() - 2 && numList.get(index).equals(numList.get(index + 2))) {
                a3.append(numList.get(index));
                index = index + 3;
            } else if (index < numList.size() - 1 &&numList.get(index).equals(numList.get(index + 1))) {
                a2.append(numList.get(index));
                index = index + 2;
            } else {
                a1.append(numList.get(index));
                index = index + 1;
            }
            if (index >= 13) break;
        }
        System.out.print(a1+",");
        System.out.print(a2+",");
        System.out.print(a3+",");
        System.out.println(a4);
    }
}
