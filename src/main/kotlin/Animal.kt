import jakarta.persistence.*

@Entity
data class Animal (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idAnimal: Long? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    val dueno : Person,
    val nameAnimal: String,
    val tipo: String
)