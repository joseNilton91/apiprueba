package apifestivo.apifestivo.Entidades;
import java.util.Date;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "festivo")
public class Festivo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_festivo")
    @GenericGenerator(name = "secuencia_festivo", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name = "nombre", length = 100, unique = true)
    private String nombre;

    @Column(name = "dia", length = 100, unique = true)
    private int dia;

    @Column(name = "mes", length = 5, nullable = true)
    private int mes;

    @Column(name = "diaspascua", length = 5, nullable = true)
    private int diaspascua;

    @Column(name = "fecha", length = 5, nullable = true)
    private Date Fecha;

    @ManyToOne
    @JoinColumn(name = "idtipo", referencedColumnName = "id")
    private Tipo tipo;

    public Festivo() 
    {

    }
    
    public Festivo(int id, String nombre, int dia, int mes, int diaspascua, Date fecha, Tipo tipo) 
    {
        this.id = id;
        this.nombre = nombre;
        this.dia = dia;
        this.mes = mes;
        this.diaspascua = diaspascua;
        Fecha = fecha;
        this.tipo = tipo;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public int getDia() 
    {
        return dia;
    }

    public void setDia(int dia) 
    {
        this.dia = dia;
    }

    public int getMes() 
    {
        return mes;
    }

    public void setMes(int mes) 
    {
        this.mes = mes;
    }

    public int getDiasPascua() 
    {
        return diaspascua;
    }

    public void setDiaspascua(int diaspascua) 
    {
        this.diaspascua = diaspascua;
    }
    
    public Date getFecha() 
    {
        return Fecha;
    }

    public void setFecha(Date fecha) 
    {
        Fecha = fecha;
    }

    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }

    public Tipo getTipo() 
    {
        return tipo;
    }

    public void setTipo(Tipo tipo) 
    {
        this.tipo = tipo;
    }

    
}
