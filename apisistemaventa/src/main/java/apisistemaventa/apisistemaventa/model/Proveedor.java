package apisistemaventa.apisistemaventa.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_proveedor")
    @GenericGenerator(name = "secuencia_proveedor", strategy = "increment")

    @Column(name = "idrutproveedor")
    private Long idRutProveedor;
    @Column(name = "nombre")
    private String Nombre;
    @Column(name = "apellidos")
    private String Apellidos;
    @Column(name = "calle")
    private String Calle;
    @Column(name = "numero")
    private String Numero;
    @Column(name = "comuna")
    private String Comuna;
    @Column(name = "ciudad")
    private String Ciudad;
    @Column(name = "telefono")
    private String Telefono;
}
