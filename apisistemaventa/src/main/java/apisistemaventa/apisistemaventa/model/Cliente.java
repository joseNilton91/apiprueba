package apisistemaventa.apisistemaventa.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_cliente")
    @GenericGenerator(name = "secuencia_cliente", strategy = "increment")
    @Column(name = "idrutcliente")
    private Long idRutCliente;
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
