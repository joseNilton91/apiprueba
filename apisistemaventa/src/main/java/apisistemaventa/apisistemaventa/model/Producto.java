package apisistemaventa.apisistemaventa.model;

import java.math.BigDecimal;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "secuencia_producto")
    @GenericGenerator(name = "secuencia_producto", strategy = "increment")

    @Column(name = "idcodigoproducto")
    private Long idCodigoProducto;

    @Column(name = "nombreproducto")
    private String NombreProducto;

    @Column(name = "precioactual_producto")
    private BigDecimal PrecioActual_Producto;

    @Column(name = "stockproducto")
    private Integer StockProducto;

    @ManyToOne
    @JoinColumn(name = "idcodigocategoria", referencedColumnName = "idcodigocategoria")
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "idrutproveedor", referencedColumnName = "idrutproveedor")
    private Proveedor proveedor;
}
