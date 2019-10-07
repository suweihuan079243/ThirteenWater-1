package game;

import java.util.ArrayList;

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
    private int flag1 = 0; //后墩牌型
    private int flag2 = 0; //中墩牌型

    //把花色去掉
    public void countPoker(ArrayList<String> handPoker)
    {

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

    //判断普通牌型
    public void judgeCardType(int size,int flag)
    {
        //前墩牌型判断
        if(size == 3)
        {
            //三条
            if (a3.length() != 0){
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
            }
            else if(a2.length() != 0){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a1.charAt(0),flag);
            }
            else{
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
            }
        }
        if(size == 5)
        {
            //判断同花顺
            //判断炸弹
            if(a4.length() != 0 && a1.length() != 0) {
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a4.charAt(0)==1?10:a4.charAt(0),flag);
                out(a1.charAt(0)==1?10:a1.charAt(0),flag);
                a4.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=1;
                else if(flag ==1) flag2=1;
            }
            //判断葫芦
            else if(a3.length() != 0 && a2.length() != 0)
            {
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                a3.deleteCharAt(0);
                a2.deleteCharAt(0);
                if (flag == 0) flag1=2;
                else if(flag ==1) flag2=2;
            }
            //判断同花
            //判断顺子(问题：只能从单张牌堆里面选顺子)
            else if(a1.length() >= 5 && judge(a1.toString())!=0)
            {
                if (judge(a1.toString())==1) System.out.println("23456");
                else if(judge(a1.toString())==2) System.out.println("34567");
                else if(judge(a1.toString())==3) System.out.println("45678");
                else if(judge(a1.toString())==4) System.out.println("56789");
                else if(judge(a1.toString())==5) System.out.println("678910");
                else if(judge(a1.toString())==6) System.out.println("78910J");
                else if(judge(a1.toString())==7) System.out.println("8910JQ");
                else if(judge(a1.toString())==8) System.out.println("910JQK");
                else if(judge(a1.toString())==9) System.out.println("10JQKA");
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
            }
            //判断三条
            else if(a3.length() != 0 && a1.length() >= 2 ){
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a3.charAt(0),flag);
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                a3.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=3;
                else if(flag ==1) flag2=3;
            }
            //判断二对
            else if(a2.length() >= 2 && a1.length() != 0 ){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a2.charAt(1),flag);
                out(a2.charAt(1),flag);
                out(a1.charAt(0),flag);
                a2.deleteCharAt(0);
                a2.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=4;
                else if(flag ==1) flag2=4;
            }
            //判断一对
            else if(a2.length()!=0 && a1.length()>=3){
                out(a2.charAt(0),flag);
                out(a2.charAt(0),flag);
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
                a2.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=5;
                else if(flag ==1) flag2=5;
            }
            //判断五张散牌
            else if(a1.length() >=5)
            {
                out(a1.charAt(0),flag);
                out(a1.charAt(1),flag);
                out(a1.charAt(2),flag);
                out(a1.charAt(3),flag);
                out(a1.charAt(4),flag);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                a1.deleteCharAt(0);
                if (flag == 0) flag1=6;
                else if(flag ==1) flag2=6;
            }
        }
    }
    //判断顺子
    private int judge(String str)
    {
        if(str.contains("23456")) return 1;
        else if(str.contains("34567")) return 2;
        else if(str.contains("45678")) return 3;
        else if(str.contains("56789")) return 4;
        else if(str.contains("678910")) return 5;
        else if(str.contains("78910J")) return 6;
        else if(str.contains("8910JQ")) return 7;
        else if(str.contains("910JQK")) return 8;
        else if(str.contains("10JQKA")) return 9;
        else return 0;
    }

    //存牌
    private void out(char c,int flag)
    {
        //存后墩牌
        if(flag == 0)
        {
            if (c=='￥') behand.add("10");
            else behand.add(Character.toString(c));
        }
        //存中墩牌
        else if(flag == 1){
            if (c=='￥') middle.add("10");
            else middle.add(Character.toString(c));
        }
        //存前墩牌
        else if(flag == 2){
            if (c=='￥') front.add("10");
            else front.add(Character.toString(c));
        }
    }
    public void play()
    {
        if (flag1 == flag2){
            String str1 = behand.toString();
            String str2 = middle.toString();
            if(str1.compareTo(str2) < 0) {
                System.out.println("后墩是："+middle);
                System.out.println("中墩是："+behand);
                System.out.println("前墩是："+front);
            }
            else {
                System.out.println("后墩是：" + behand);
                System.out.println("中墩是：" + middle);
                System.out.println("前墩是：" + front);
          }
        }
        else {
            System.out.println("后墩是：" + behand);
            System.out.println("中墩是：" + middle);
            System.out.println("前墩是：" + front);
        }
    }
}
