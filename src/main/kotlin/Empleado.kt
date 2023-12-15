import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.OneToOne

@Entity
data class Empleado(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idEmpleado: Long? = null,
    val nombre : String,
    @OneToOne
    @JoinColumn(name = "id_direccion")
    val direccion: Direccion
)