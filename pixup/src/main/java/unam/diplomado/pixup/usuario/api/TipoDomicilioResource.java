package unam.diplomado.pixup.usuario.api;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import unam.diplomado.pixup.usuario.domain.TipoDomicilio;
import unam.diplomado.pixup.usuario.repository.TipoDomicilioRepository;

import java.util.Collection;
import java.util.List;

@RequestScoped
public class TipoDomicilioResource implements TipoDomicilioApi {

    @Inject
    private TipoDomicilioRepository tipoDomicilioRepository;

    @Override
    public Collection<TipoDomicilio> getAll() {
        return tipoDomicilioRepository.findAll();
    }
}
