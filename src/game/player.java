package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeSet;

public class player {
    private String name;
    private TreeSet<Integer> handPokerNum = new TreeSet<Integer>();
    private ArrayList<String> handPoker = new ArrayList<String>();
    private int winWater;

    public player(String name) {
        this.name = name;
    }

    public ArrayList<String> getHandPoker() {
        return handPoker;
    }

    public TreeSet<Integer> getHandPokerNum() {
        return handPokerNum;
    }

    public int getWinWater() {
        return winWater;
    }

    public void setWinWater(int winWater) {
        this.winWater = winWater;
    }


    public void lookPoker(HashMap<Integer,String> hm)
    {
        System.out.print(this.name + "的牌是：");
        for (Integer key : handPokerNum) {
            handPoker.add(hm.get(key));
        }
        System.out.println(handPoker);
    }
}
