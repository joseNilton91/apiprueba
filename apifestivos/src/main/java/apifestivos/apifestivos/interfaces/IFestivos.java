package apifestivos.apifestivos.interfaces;

import java.util.Date;
import java.util.List;

public interface IFestivos {
    public boolean esFestivo(Date fecha);
    
    public List<Date> obtenerFestivos(int año);

}
