package myapp;

public class Link {
    
    public Link() {}

    public void hit (Hitable hitable) {
        System.out.println("Hiya...");
        hitable.hit(3);
    }
    
}
