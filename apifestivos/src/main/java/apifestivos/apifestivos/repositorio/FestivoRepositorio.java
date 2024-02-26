package apifestivos.apifestivos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import apifestivos.apifestivos.modelo.Festivo;

public interface FestivoRepositorio extends JpaRepository<Festivo, Long> {

}
