package me.dio.credit.request.system.DTO.Customer

import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal

data class CustomerUpdateDTO(

        val firstName: String,
        val lastName: String,
        var income: BigDecimal,
        val zipCode: String,
        val street: String
){
    fun toEntty(customer: Customer): Customer{

        customer.firstName = this.firstName
        customer.lastName = this.lastName
        customer.income = this.income
        customer.address.zipCode = this.zipCode
        customer.address.street = this.street

        return customer
    }

}
