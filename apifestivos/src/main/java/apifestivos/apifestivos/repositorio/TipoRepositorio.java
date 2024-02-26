package apifestivos.apifestivos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import apifestivos.apifestivos.modelo.Festivo;


@Repository
public interface TipoRepositorio extends JpaRepository<Festivo, Long> {

}
