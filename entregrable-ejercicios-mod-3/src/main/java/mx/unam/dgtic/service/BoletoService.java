package mx.unam.dgtic.service;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mx.unam.dgtic.entities.Boleto;
import mx.unam.dgtic.entities.Funcion;
import mx.unam.dgtic.repository.IBoletoRepository;
import mx.unam.dgtic.repository.impl.BoletoRepository;
import java.time.LocalDate;
import java.util.List;

public class BoletoService {
	private IBoletoRepository boletoRepository;

	public BoletoService() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("micursojpa");
		EntityManager em = emf.createEntityManager();
		this.boletoRepository = new BoletoRepository(em);
	}

	public Boleto findBoletoById(int id) {
		return boletoRepository.findById(id);
	}

	public void displayBoleto(int id) {
		Boleto boleto = this.findBoletoById(id);
		System.out.println("boleto = " + boleto);
	}

	public void saveBoleto(Boleto boleto) {
		if (boleto.getIdBoleto() == 0) {
			this.boletoRepository.save(boleto);
		} else {
			this.boletoRepository.update(boleto);
		}
	}

	public void deleteBoleto(int id) {
		Boleto boleto = this.findBoletoById(id);
		if (boleto != null) {
			this.boletoRepository.delete(boleto);
		}
	}

	public java.util.List<Boleto> findByZonaAsiento(String prefijo) {
		return boletoRepository.findByZonaAsiento(prefijo);
	}

	public java.util.List<Boleto> findByIdFuncion(int idFuncion) {
		return boletoRepository.findByIdFuncion(idFuncion);
	}

	public java.util.List<Boleto> findByFechaCompra(LocalDate fecha) {
		return boletoRepository.findByFechaCompra(fecha);
	}

	public Long countByIdFuncion(int idFuncion) {
		return boletoRepository.countByIdFuncion(idFuncion);
	}

    public List<Boleto> findByFuncionAndFecha(Funcion funcion, LocalDate fecha) {
        return boletoRepository.findByFuncionAndFecha(funcion, fecha);
    }

    public List<Object[]> countBoletosPorFuncion() {
        return boletoRepository.countBoletosPorFuncion();
    }
}
