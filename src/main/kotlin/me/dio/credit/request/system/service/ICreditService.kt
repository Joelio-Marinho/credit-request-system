package me.dio.credit.request.system.service

import me.dio.credit.request.system.entity.Credit
import java.util.*

interface ICreditService {

    fun save(credit: Credit): Credit
    fun findAllByCustomer(customerId: Long): List<Credit>
    fun findByCreditCode(customerId: Long,creditCode: UUID): Credit

}