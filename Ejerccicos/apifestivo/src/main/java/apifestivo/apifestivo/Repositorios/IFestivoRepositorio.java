package apifestivo.apifestivo.Repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import apifestivo.apifestivo.Entidades.Festivo;

public interface IFestivoRepositorio extends JpaRepository<Festivo, Long>
{
    
}
