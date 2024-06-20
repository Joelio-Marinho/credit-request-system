package me.dio.credit.request.system.DTO.Credit

import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.entity.Enum.Status
import java.math.BigDecimal
import java.util.*

data class CreditView(

        val creditCode: UUID,
        val creditValue: BigDecimal,
        val numberOfInstallments: Int,
        val status: Status,
        val emailCustomer: String?,
        val incomerCustomer: BigDecimal?
)
{
    constructor(credit: Credit): this(
            creditCode = credit.credtCode,
            creditValue = credit.creditValue,
            numberOfInstallments = credit.numberOfInstallments,
            status = credit.status,
            emailCustomer = credit.customer?.email,
            incomerCustomer = credit.customer?.income
    )
}
