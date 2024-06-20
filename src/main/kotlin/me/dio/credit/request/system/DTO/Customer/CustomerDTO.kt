package me.dio.credit.request.system.DTO.Customer

import me.dio.credit.request.system.entity.Address
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerDTO (

    val firstName: String,
    val lastName: String,
    val cpf: String,
    val income:BigDecimal,
    var email: String,
    val password: String,
    val zipCode: String,
    val street: String,

){
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