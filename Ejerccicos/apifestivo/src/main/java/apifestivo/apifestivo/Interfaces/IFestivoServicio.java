package apifestivo.apifestivo.Interfaces;
import java.util.Date;
import java.util.List;


public interface IFestivoServicio 
{
    public boolean esFestivo(Date fecha); 
    
    public boolean esFechaValida(String strFecha);

    public List<Date> obtenerFestivos(int año);

}
