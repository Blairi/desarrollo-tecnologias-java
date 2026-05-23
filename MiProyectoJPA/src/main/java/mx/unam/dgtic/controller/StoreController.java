package mx.unam.dgtic.controller;

import mx.unam.dgtic.dto.BookDTO;
import mx.unam.dgtic.service.StoreService;

public class StoreController {

    private StoreService storeService;

    public StoreController() {
        this.storeService = new StoreService();
    }

    public void displayBook(String id) {
        System.out.println("Displaying book with id = " + id);
        storeService.displayBook(id);
    }

    // creacion
    public void createBook(BookDTO book) {
        System.out.println("Creando un nuevo libro con id " + book.getId());
        storeService.createBook(book);

    }

    // eliminacion
    public void deleteBook(String id) {
        System.out.println("Eliminando el libro con Id" + id);
        storeService.deleteBook(id);
    }

    // actualizacion
    public void updateBook(BookDTO book) {
        System.out.println("Actualizando el libro con id " + book.getId());
        boolean resultUpdate = storeService.updateBook(book);
    }

}
