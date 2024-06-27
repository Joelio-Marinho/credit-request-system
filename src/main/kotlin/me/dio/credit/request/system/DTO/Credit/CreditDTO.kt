package me.dio.credit.request.system.DTO.Credit

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.Negative
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDTO(

    @field:NotNull(message = "Invalid Credit")
    val creditValue: BigDecimal,

    @field:Future(message = "Invalid date passad")
    val dayFirstInstallment: LocalDate,

    @field:Positive(message = "Invalid number negative")
    val numberOfInstallments: Int,

    @field:NotNull(message = "Invalid Credit")
    var customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)

    )

}
