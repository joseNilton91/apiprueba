package apifestivo.apifestivo.servicio;
import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apifestivo.apifestivo.dtos.FestivoDto;
import apifestivo.apifestivo.interfaces.IFestivos;
import apifestivo.apifestivo.modelo.Festivo;
import apifestivo.apifestivo.repositorio.FestivoRepositorio;

@Service
public class FestivosServicio implements IFestivos 
{
    @Autowired
    private FestivoRepositorio repositorio;

    private Date obtenerDomingoPascua(int año) {
        int mes, dia, A, B, C, D, E, M, N;
        M = 0;
        N = 0;
        if (año >= 1583 && año <= 1699) {
            M = 22;
            N = 2;
        } else if (año >= 1700 && año <= 1799) {
            M = 23;
            N = 3;
        } else if (año >= 1800 && año <= 1899) {
            M = 23;
            N = 4;
        } else if (año >= 1900 && año <= 2099) {
            M = 24;
            N = 5;
        } else if (año >= 2100 && año <= 2199) {
            M = 24;
            N = 6;
        } else if (año >= 2200 && año <= 2299) {
            M = 25;
            N = 0;
        }

        A = año % 19;
        B = año % 4;
        C = año % 7;
        D = ((19 * A) + M) % 30;
        E = ((2 * B) + (4 * C) + (6 * D) + N) % 7;

        
        if (D + E < 10) {
            dia = D + E + 22;
            mes = 3;
        } else {
            dia = D + E - 9;
            mes = 4;
        }

        
        if (dia == 26 && mes == 4)
            dia = 19;
        if (dia == 25 && mes == 4 && D == 28 && E == 6 && A > 10)
            dia = 18;
        return new Date(año - 1900, mes - 1, dia);
    }

    private Date agregarDias(Date fecha, int dias) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        cal.add(Calendar.DATE, dias);
        return (Date) cal.getTime();
    }

    private Date siguienteLunes(Date fecha) {
        Calendar c = Calendar.getInstance();
        c.setTime(fecha);
        if (c.get(Calendar.DAY_OF_WEEK) > Calendar.MONDAY)
            fecha = agregarDias(fecha, 9 - c.get(Calendar.DAY_OF_WEEK));
        else if (c.get(Calendar.DAY_OF_WEEK) < Calendar.MONDAY)
            fecha = agregarDias(fecha, 1);
        return fecha;
    }

    private List<Festivo> calcularFestivos(List<Festivo> festivos, int año) {
        if (festivos != null) {
            Date pascua = obtenerDomingoPascua(año);
            int i = 0;
            for (final Festivo festivo : festivos) {
                switch (festivo.getTipo().getId()) {
                    case 1:
                        festivo.setFecha(new Date(año - 1900, festivo.getMes() - 1, festivo.getDia()));
                        break;
                    case 2:
                        festivo.setFecha(siguienteLunes(new Date(año - 1900, festivo.getMes() - 1, festivo.getDia())));
                        break;
                    case 3:
                        festivo.setFecha(agregarDias(pascua, festivo.getDiasPascua()));
                        break;
                    case 4:
                        festivo.setFecha(siguienteLunes(agregarDias(pascua, festivo.getDiasPascua())));
                        break;
                }
                festivos.set(i, festivo);
                i++;
            }
        }
        return festivos;
    }

    public List<FestivoDto> obtenerFestivos(int año) {
        List<Festivo> festivos = repositorio.findAll();
        festivos = calcularFestivos(festivos, año);
        List<FestivoDto> fechas = new ArrayList<FestivoDto>();
        for (final Festivo festivo : festivos) {
            fechas.add(new FestivoDto(festivo.getNombre(), festivo.getFecha()));
        }
        return fechas;
    }

    private boolean fechasIguales(Date fecha1, Date fecha2) {
        if (fecha1 != null && fecha2 != null) {
            return fecha1.getYear() == fecha2.getYear() && fecha1.getMonth() == fecha2.getMonth()
                    && fecha1.getDate() == fecha2.getDate(); 
        } else {
            return false; 
        }
    }

    private boolean esFestivo(List<Festivo> festivos, Date fecha) {
        if (festivos != null) {
            festivos = calcularFestivos(festivos, fecha.getYear() + 1900);
            for (final Festivo festivo : festivos) {
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                if (fechasIguales(festivo.getFecha(), fecha) || c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY)
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean esFestivo(Date fecha) {
        List<Festivo> festivos = repositorio.findAll();
        return esFestivo(festivos, fecha);
    }

    @Override
    public boolean esFechaValida(String strFecha) {
        try {
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            df.setLenient(false);
            df.parse(strFecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    @Override
    public Festivo obtenerAños(int año) {
        Calendar calendario = Calendar.getInstance();
        int anioActual = calendario.get(Calendar.YEAR);

        if (año >= 0 && año <= anioActual) {
            // Crear una instancia de Festivo con el año especificado
            Festivo festivo = new Festivo();
            festivo.setAnio(año); // Asumiendo que Festivo tiene un método setAnio para establecer el año
            return festivo;
        } else {
            throw new IllegalArgumentException("Año no válido, deebe estar entre 0 y el año.");
        }
    }

    @Override
    public Festivo obtenerMeses(int mes) {
        if ((mes >= 1 && mes <= 12)) {
            Festivo festivo = new Festivo();
            festivo.setMes(mes);
            return festivo;
        } else {
            throw new IllegalArgumentException("Mes no valido, debe estar entre 1 y 12");
        }
    }

    @Override
    public Festivo obtenerDias(int dia) {

        if ((dia >= 1 && dia <= 31)) {
            Festivo festivo = new Festivo();
            festivo.setDia(dia);
            return festivo;
        } else {
            throw new IllegalArgumentException("Dia no valido, debe estar entre 1 y 31");
        }
    }

    @Override
    public List<Festivo> listar() {
        return repositorio.findAll();
    }
}