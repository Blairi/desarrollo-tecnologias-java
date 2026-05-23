package mx.unam.dgtic.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Book;

public class BookDAO {
    // EntityManager - EntityManagerFactory
    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public BookDAO() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("micursojpa-pu");
        // brindar operaciones CRUD para poder gestionar las entidades
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    // SELECT * FROM BOOK WHERE ISBN = ID;
    public Book findBook(String id) {
        // la clase debe ser @Entity
        try {
            return this.entityManager.find(Book.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public void insertBook(Book book) {
        try {
            // Iniciar una transaccion
            this.entityManager.getTransaction().begin();

            // Guardar / persistir el objeto
            this.entityManager.persist(book);

            // Comprometer / confirmar la consulta
            this.entityManager.getTransaction().commit();

        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public void updateBook(Book book) {
        try {
            this.entityManager.getTransaction().begin();
            this.entityManager.merge(book);
            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public void deleteBook(String id) {
        try {
            this.entityManager.getTransaction().begin();

            Book bookToDelete = this.findBook(id);
            this.entityManager.remove(bookToDelete);

            this.entityManager.getTransaction().commit();
        } catch (Exception e) {
            this.entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    public Book findNameBookById(String id) {
        try {
            // id named param
            String name = (String)this.entityManager.createQuery("SELECT b.* FROM Book b WHERE isbn = :id")
                    .setParameter("id", id)
                    .getSingleResult();

            return new Book(null, name);
        } catch (Exception e) {
            return null;
        }
    }
}
