package apisistemaventa.apisistemaventa.model;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_categoria")
    @GenericGenerator(name = "secuencia_categoria", strategy = "increment")

    @Column(name = "idcodigocategoria")
    private Long idCodigoCategoria;

    @Column(name = "nomcategoria")
    @NotNull
    private String NomCategoria;
    @NotNull
    @Column(name = "descripcioncate")
    private String descripcionCate;

}
