package me.dio.credit.request.system.DTO.Credit

import me.dio.credit.request.system.entity.Credit
import java.math.BigDecimal
import java.util.*

data class CreditViewList(
        val creditCode: UUID,
        val creditValue: BigDecimal,
        val numberOfInstallments: Int,
){
    constructor(credit: Credit): this(
            creditCode = credit.credtCode,
            creditValue = credit.creditValue,
            numberOfInstallments = credit.numberOfInstallments
    )
}
