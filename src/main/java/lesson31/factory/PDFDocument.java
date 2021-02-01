package lesson31.factory;

public class PDFDocument implements Document{
    @Override
    public void print() {
        System.out.println("PDF document");
    }
}
