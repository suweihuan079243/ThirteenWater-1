package game;

import java.util.HashMap;
import java.util.TreeSet;

public class player {
    private String name;
    private TreeSet<Integer> handPoker = new TreeSet<Integer>();
    private int winWater;

    public player(String name) {
        this.name = name;
    }

    public TreeSet<Integer> getHandPoker() {
        return handPoker;
    }

    public void setHandPoker(TreeSet<Integer> handPoker) {
        this.handPoker = handPoker;
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
        for (Integer key : handPoker) {
            String value = hm.get(key);
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
