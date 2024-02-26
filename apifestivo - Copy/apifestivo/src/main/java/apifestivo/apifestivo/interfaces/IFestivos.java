package apifestivo.apifestivo.interfaces;
import java.util.Date;
import java.util.List;

import apifestivo.apifestivo.dtos.FestivoDto;
import apifestivo.apifestivo.modelo.Festivo;

public interface IFestivos 
{
    public List<Festivo> listar();

    public boolean esFestivo(Date fecha);

    public Festivo obtenerAños(int año);

    public Festivo obtenerMeses(int mes);

    public Festivo obtenerDias(int dia);

    public boolean esFechaValida(String strFecha);

    public List<FestivoDto> obtenerFestivos(int año);


}
