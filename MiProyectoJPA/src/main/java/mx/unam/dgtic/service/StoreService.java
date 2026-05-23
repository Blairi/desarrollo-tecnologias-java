package mx.unam.dgtic.service;

import mx.unam.dgtic.dao.BookDAO;
import mx.unam.dgtic.dto.BookDTO;
import mx.unam.dgtic.entities.Book;

import java.util.Objects;

public class StoreService {

    private BookDAO bookDAO;

    public StoreService() {
        this.bookDAO = new BookDAO();
    }

    public void displayBook(String id) {

        if (id == null || id.isEmpty()) {
            System.err.println("Error: Book Id cannot be null or empty");
            return;
        }

        Book bookEntity = this.bookDAO.findBook(id);
        String isbnEntity = bookEntity.getIsbn();
        String bookNameEntity = bookEntity.getName();

        System.out.println("isbnEntity = " + isbnEntity);
        System.out.println("bookNameEntity = " + bookNameEntity);
    }

    public void createBook(BookDTO book) {
        // validar DTO
        if (Objects.isNull(book)) {
            System.err.println("Error: Book DTO cannot be null");
            return;
        }

        if (Objects.isNull(book.getName()) || book.getName().isEmpty()) {
            System.err.println("Book cannot be null");
            return;
        }

        Book bookEntity = new Book();
        bookEntity.setIsbn(book.getId());
        bookEntity.setName(book.getName());
        bookDAO.insertBook(bookEntity);
    }

    public boolean deleteBook(String id) {
        // validaciones
        if (id.isEmpty() || id == null) {
            System.err.println("Error: Book Id cannot be null or empty.");
            return false;
        }

        if (!id.startsWith("ISBN")) {
            System.out.println("Error: Book id must start with 'ISBN'");
            return false;
        }

        Book bookExists = this.bookDAO.findBook(id);
        if (Objects.isNull(bookExists)) {
            throw new RuntimeException(id + " not exists");
        }

        this.bookDAO.deleteBook(id);
        return true;
    }

    public boolean updateBook(BookDTO book) {

        if (Objects.isNull(book)) {
            System.err.println("Error: Book DTO cannot be null");
            return false;
        }

        if (Objects.isNull(book.getId()) || book.getId().isEmpty()) {
            System.err.println("Error: Book Id cannot be null or empty");
            return false;
        }

        if (!book.getId().startsWith("ISBN")) {
            System.err.println("Error: Book id must start with 'ISBN'");
            return false;
        }

        if (Objects.isNull(book.getName()) || book.getName().isEmpty()) {
            System.err.println("Error: Book name cannot be null or empty");
            return false;
        }

        // 2. Verificar si existe
        Book bookEntity = this.bookDAO.findBook(book.getId());

        if (Objects.isNull(bookEntity)) {
            throw new RuntimeException(book.getId() + " not exists");
        }

        // 3. Actualizar campos
        bookEntity.setName(book.getName());
        // Si tuvieras más campos, aquí los actualizas

        // 4. Persistir cambios
        this.bookDAO.updateBook(bookEntity);

        return true;
    }
}
