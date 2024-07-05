package factory;

// public class Document {
//     public void open(String type) {
//         if (type.equals("word")) {
//             System.out.println("Opening Word document...");
//         } else if (type.equals("pdf")) {
//             System.out.println("Opening PDF document...");
//         } else {
//             System.out.println("Unknown document type.");
//         }
//     }
// }

// Suppose you have a Document class that creates different types of documents (e.g., WordDocument, PDFDocument)
// this code have bad smell:
    // violates open closed principle by adding a new document type requires modifying the Document class
    // it uses conditional logic to differentiate between document types.

// we first define interface called Document
// then implement concrete document classes -> WordDocument, PDFDocument
// create abstract class DocumentCreator to declare factory method
// implement concrete creators for each document type -> WordDocumentCreator, PDFDocumentCreator

// so that the DocumentCreator ensures the code open for extension and close for modification
// the creation of documents is delegated to the factory method
// ensures each type of document is encapsulated in its own classes