package mx.unam.dgtic;

import mx.unam.dgtic.controller.StoreController;
import mx.unam.dgtic.dto.BookDTO;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        StoreController controller = new StoreController();
        controller.displayBook("ISBN-001");

        // creamos nuestro dto para nuevo libro
        var newBook = new BookDTO("ISBN-805", "How program in Java", new Date());
//        controller.createBook(newBook);

        // Delete
        var idToDelete = "ISBN-805";
        controller.deleteBook(idToDelete);

        var idToUpdate = "ISBN-002";
        var updatedBook = new BookDTO(idToUpdate, "Mastering Spring", new Date());
        controller.updateBook(updatedBook);
    }
}