package myapp;

import java.util.LinkedList;
import java.util.List;

public class GameMain {
    public static void main(String args[]) {

        List<Hitable> enemies = new LinkedList<>();
        for (int i = 0; i < 3; i++) {
            enemies.add(new Troll());
        }

        enemies.add(new Gnome());
        enemies.add(new Tree());

        for (Hitable h : enemies) {
            System.out.printf(">> %s\n", h);
        }

        Link link = new Link();

        Hitable ht = new Tree();
        if (ht instanceof Tree) { // find out if h is Tree and then instantiate it
            Tree t = (Tree)ht;
        }

        for (Hitable h : enemies) {
            link.hit(h);
            System.out.printf(">> %s\n", h);
        }
    }
}
