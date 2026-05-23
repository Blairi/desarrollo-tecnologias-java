package unam.diplomado.pixup.colonia.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;
import unam.diplomado.pixup.colonia.repository.ColoniaRepository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RequestScoped
public class ColoniaResource implements ColoniaApi{

    @Inject
    private ColoniaRepository coloniaRepository;

    @Override
    public Response getColoniaById(Integer id) {
        Optional<Colonia> colonia = coloniaRepository.findById(id);

        if (colonia.isPresent()) {
            return Response
                    .status(Response.Status.OK)
                    .entity(colonia.get())
                    .build();
        } else {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(null)
                    .build();
        }

    }

    @Override
    public Collection<Colonia> getColoniasByCp(String cp) {
        return List.of();
    }
}
