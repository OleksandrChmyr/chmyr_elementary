package lesson31.factory;

public class TXTDocument implements Document{
    @Override
    public void print() {
        System.out.println("TXT document");
    }
}
