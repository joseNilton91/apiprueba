package apifestivo.apifestivo.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import apifestivo.apifestivo.modelo.Tipo;

public interface TipoRepositorio extends JpaRepository<Tipo, Long> 
{

}
