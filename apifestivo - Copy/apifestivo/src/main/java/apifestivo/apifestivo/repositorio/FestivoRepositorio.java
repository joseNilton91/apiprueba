package apifestivo.apifestivo.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import apifestivo.apifestivo.modelo.Festivo;

public interface FestivoRepositorio extends JpaRepository<Festivo, Long> 
{

}