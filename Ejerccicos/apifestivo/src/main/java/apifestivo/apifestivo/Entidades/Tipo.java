package apifestivo.apifestivo.Entidades;
import org.hibernate.annotations.GenericGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo")
public class Tipo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_Tipo")
    @GenericGenerator(name = "secuencia_Tipo", strategy="increment")
    @Column(name = "id")
    private int id;

    @Column(name = "tipo", length = 100, unique = true)
    private int tipo;

    public Tipo() 
    {

    }

    public Tipo(int id, int tipo) 
    {
        this.id = id;
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

    public int getTipo() 
    {
        return tipo;
    }

    public void setTipo(int tipo) 
    {
        this.tipo = tipo;
    }
}
