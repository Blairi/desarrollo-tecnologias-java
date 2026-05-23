package unam.diplomado.pixup.colonia.repository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class JpaColoniaRepository implements ColoniaRepository{

    @PersistenceContext(unitName = "pixup")
    private EntityManager entityManager;

    @Override
    public List<Colonia> findByCp(String cp) {
        TypedQuery<Colonia> query = entityManager.createQuery(
                "SELECT c FROM Colonia WHERE c.cp = ?1",
                Colonia.class
        );
        query.setParameter(1, cp);
        return query.getResultList();
    }

    @Override
    public Optional<Colonia> findById(Integer id) {
        Colonia colonia =
                entityManager.find(Colonia.class, id);
        return colonia != null
                ? Optional.of(colonia)
                : Optional.empty();
    }
}
