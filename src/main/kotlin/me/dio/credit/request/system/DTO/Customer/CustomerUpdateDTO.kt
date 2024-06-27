package me.dio.credit.request.system.DTO.Customer

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO(

    @field:NotEmpty(message = "Invalid firstName")
    val firstName: String,

    @field:NotEmpty(message = "Invalid lastName")
    val lastName: String,

    @field:NotNull(message = "Invalid income")
    var income: BigDecimal,

    @field:NotEmpty(message = "Invalid zipCode")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid street")
    val street: String
) {
    fun toEntty(customer: Customer): Customer {

        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer
    }

}
