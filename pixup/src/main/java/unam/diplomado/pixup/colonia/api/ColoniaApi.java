package unam.diplomado.pixup.colonia.api;

import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import unam.diplomado.pixup.colonia.domain.Colonia;

import java.util.Collection;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("colonias")
public interface ColoniaApi {

    @GET
    @Path("{id}")
    Response getColoniaById(@PathParam("id") Integer id);

    @GET
    Collection<Colonia> getColoniasByCp(
            @NotBlank @QueryParam("cp") String cp);

}
