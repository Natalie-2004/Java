package factory;

// public class Main {
//     public static void main(String[] args) {
//         Document doc = new Document();
//         doc.open("word");
//         doc.open("pdf");
//     }
// }

// new main
public class Main {
    public static void main(String[] args) {
        DocumentCreator wordCreator = new WordDocumentCreator();
        wordCreator.openDocument(); // Output: Opening Word document...

        DocumentCreator pdfCreator = new PDFDocumentCreator();
        pdfCreator.openDocument(); // Output: Opening PDF document...
    }
}