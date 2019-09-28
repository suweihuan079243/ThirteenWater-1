package game;

import java.util.ArrayList;
import java.util.HashMap;

public class Operation {
    /**
     * a1的值为手牌中重复一次(单张牌)的牌，a2的值为手牌中重复二次(对牌)的牌，
     * a3的值为手牌中重复三次(三张)的牌，a4的值为手牌中重复四次(炸弹)的牌。
     */
    private StringBuffer a1 = new StringBuffer();
    private StringBuffer a2 = new StringBuffer();
    private StringBuffer a3 = new StringBuffer();
    private StringBuffer a4 = new StringBuffer();
    private ArrayList<String> numList = new ArrayList<>(); //花色去掉后的手牌
    private ArrayList<String> front = new ArrayList<>();//前墩
    private ArrayList<String> middle = new ArrayList<>();//中墩
    private ArrayList<String> behand = new ArrayList<>();//后墩


    public void countPoker(ArrayList<String> handPoker)
    {
        //把花色去掉
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
            } else if (index < numList.size() - 1 && numList.get(index).equals(numList.get(index + 1))) {
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

    public void judgeCardType(int size)
    {
        //前墩牌型判断
        if(size == 3)
        {
            //三条
            if (a3.length() != 0){
                System.out.print(a3.charAt(0));
                System.out.print(a3.charAt(0));
                System.out.println(a3.charAt(0));
            }
            else if(a2.length() != 0){
                System.out.print(a2.charAt(0));
                System.out.print(a2.charAt(0));
                System.out.println(a1.charAt(0));
            }
            else{
                System.out.print(a1.charAt(0));
                System.out.print(a1.charAt(1));
                System.out.println(a1.charAt(2));
            }
        }
        if(size == 5)
        {
            //判断同花顺
            //判断炸弹
            if(a4.length() != 0 && a1.length() != 0) {
                System.out.print(a4.charAt(0));
                System.out.print(a4.charAt(0));
                System.out.print(a4.charAt(0));
                System.out.print(a4.charAt(0));
                System.out.println(a1.charAt(0));
                a4.deleteCharAt(0);
                a1.deleteCharAt(0);
            }
            //判断葫芦
            else if(a3.length() != 0 && a2.length() != 0)
            {
                System.out.print(a3.charAt(0));
                System.out.print(a3.charAt(0));
                System.out.print(a3.charAt(0));
                System.out.print(a2.charAt(0));
                System.out.println(a2.charAt(0));
                a3.deleteCharAt(0);
                a2.deleteCharAt(0);
            }
            //判断同花
            //判断顺子(问题：只能从单张牌堆里面选顺子)
            else if(a1.length() >= 5 && judge(a1.toString())!=0)
            {
                if (judge(a1.toString())==1) System.out.println("23456");
                else if(judge(a1.toString())==3) System.out.println("34567");
                else if(judge(a1.toString())==4) System.out.println("45678");
                else if(judge(a1.toString())==5) System.out.println("56789");
                else if(judge(a1.toString())==6) System.out.println("678910");
                else if(judge(a1.toString())==7) System.out.println("78910J");
                else if(judge(a1.toString())==8) System.out.println("8910JQ");
                else if(judge(a1.toString())==9) System.out.println("910JQK");
                else if(judge(a1.toString())==2) System.out.println("10JQKA");
            }
            //判断三条
            else if(a3.length() != 0 && a1.length() >= 2 ){
                System.out.print(a3.charAt(0));
                System.out.print(a3.charAt(0));
                System.out.print(a3.charAt(0));
                System.out.print(a1.charAt(0));
                System.out.print(a1.charAt(1));
                a3.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
            }
            //判断二对
            else if(a2.length() >= 2 && a1.length() != 0 ){
                System.out.print(a2.charAt(0));
                System.out.print(a2.charAt(0));
                System.out.print(a2.charAt(1));
                System.out.print(a2.charAt(1));
                System.out.print(a1.charAt(0));
                a2.deleteCharAt(0);
                a2.deleteCharAt(0);
                a1.deleteCharAt(0);
            }
        }
    }
    //判断顺子
    private int judge(String str)
    {
        if(str == "23456") return 1;
        else if(str == "34567") return 2;
        else if(str == "45678") return 3;
        else if(str == "56789") return 4;
        else if(str == "678910") return 5;
        else if(str == "78910J") return 6;
        else if(str == "8910JQ") return 7;
        else if(str == "910JQk") return 8;
        else if(str == "10JQKA") return 9;
        else return 0;
    }
}
