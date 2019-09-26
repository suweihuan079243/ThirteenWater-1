package game;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        //洗牌
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        ArrayList<Integer> arr = new ArrayList<Integer>();

        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

        int index = 0;
        for (String number : numbers) {
            for (String color : colors) {
                String pocker = color.concat(number);
                hm.put(index, pocker);
                arr.add(index);
                index++;
            }
        }
        Collections.shuffle(arr);

        player player1 = new player("Yasuo");
        player player2 = new player("Zed");
        player player3 = new player("Rivven");
        player player4 = new player("Leesin");

        dealer d = new dealer();
        d.fapai(player1,player2,player3,player4,arr);

        player1.lookPoker(hm);
        player2.lookPoker(hm);
        player3.lookPoker(hm);
        player4.lookPoker(hm);
    }
}
