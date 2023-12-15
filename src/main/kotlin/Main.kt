// src/main/kotlin/com/ejemplo/Main.kt

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence
import kotlin.math.E

fun main() {
    //Parte ORM
    val entityManagerFactory: EntityManagerFactory = Persistence.createEntityManagerFactory("ejemplo")

    val entityManager: EntityManager = entityManagerFactory.createEntityManager()

    val listaMascotas = mutableListOf<Animal>()

    val person = Person(name =  "John Doe", age = 30, mascotas = listaMascotas)
    val animal = Animal(nameAnimal = "Bady", dueno = person, tipo = "Perro")
    listaMascotas.add(animal)
    val direccion = Direccion(localidad = "Cádiz", pais = "España", direccion = "Av. de las Cortes")
    val empleado = Empleado(nombre = "Mario García", direccion = direccion)

    entityManager.transaction.begin()
    entityManager.persist(person)
    entityManager.persist(animal)
    entityManager.persist(direccion)
    entityManager.persist(empleado)
    entityManager.transaction.commit()

    val personas: List<Person> = entityManager.createQuery("FROM Person", Person::class.java).resultList
    println("Número de personas " + personas.size)

    println("Personas en la tabla:")
    for (p in personas) {
        println("ID: ${p.id}, Nombre: ${p.name}, Edad: ${p.age}")
    }

    val animales: List<Animal> = entityManager.createQuery("FROM Animal", Animal::class.java).resultList
    println("Número de animales " + animales.size)

    println("Animales en la tabla:")
    for (a in animales) {
        println("ID: ${a.idAnimal}, ID_Dueño:${a.dueno}, Nombre: ${a.nameAnimal}, Tipo: ${a.tipo}")
    }

    entityManager.close()
    entityManagerFactory.close()
}