package lesson31.factory;

public class TXTFactory implements Factory{
    @Override
    public Document getDocument() {
        return new TXTDocument();
    }
}
