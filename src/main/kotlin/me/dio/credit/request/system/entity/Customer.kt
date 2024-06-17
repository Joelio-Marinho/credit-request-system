package me.dio.credit.request.system.entity

import jakarta.persistence.*

@Entity
@Table(name = "client")
data class Customer(

        @Column(nullable = false)
        var firstName: String = "",

        @Column(nullable = false)
        var lastName: String = "",

        @Column(nullable = false, unique = true)
        val cpf: String,

        @Column(nullable = false, unique = true)
        var email: String = "",

        @Column(nullable = false)
        val password: String = "",

        @Column(nullable = false)
        @Embedded
        var address: Address = Address(),

        @Column(nullable = false)
        @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer",cascade = arrayOf( CascadeType.REMOVE))
        var credits: List<Credit> = mutableListOf(),
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null
)
