package lesson31;

import lesson31.factory.Document;
import lesson31.factory.PDFFactory;
import lesson31.factory.TXTFactory;

import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        Document txt = getDocument("TXT");
        Document pdf = getDocument("PDF");

       if (Objects.nonNull(txt)) txt.print();
       if (Objects.nonNull(pdf)) pdf.print();


    }
    private static Document getDocument(String factory){
        switch (factory){
            case "TXT":
                return new TXTFactory().getDocument();
            case "PDF":
                return new PDFFactory().getDocument();
        }
        return null;
    }
}
