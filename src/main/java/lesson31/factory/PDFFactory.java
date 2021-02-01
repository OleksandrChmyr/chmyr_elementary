package lesson31.factory;

public class PDFFactory implements Factory{
    @Override
    public Document getDocument() {
        return new PDFDocument();
    }
}
