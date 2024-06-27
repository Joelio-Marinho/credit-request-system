package me.dio.credit.request.system.DTO.Customer

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Address
import me.dio.credit.request.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDTO(

    @field:NotEmpty(message = "Invalid name")
    val firstName: String,

    @field:NotEmpty(message = "Invalid last Name")
    val lastName: String,

    @field:NotEmpty(message = "Invalid cpf")
    @field:CPF(message = "This invalid cpf")
    val cpf: String,

    @field:NotNull(message = "Invalid income")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid email")
    @field:Email(message = "invalid email")
    var email: String,

    @field:NotEmpty(message = "Invalid password")
    val password: String,

    @field:NotEmpty(message = "Invalid zipCode")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid street")
    val street: String,

    ) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )

    )
}