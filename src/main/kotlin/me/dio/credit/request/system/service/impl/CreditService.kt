package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.exception.BusinessException
import me.dio.credit.request.system.repositories.CreditRepository
import me.dio.credit.request.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService( private val creditRepository: CreditRepository, private val customerService: CustomerService): ICreditService {
    override fun save(credit: Credit): Credit {
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
       return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
       val credit: Credit =  (this.creditRepository.findByCredtCode(creditCode)
               ?: throw BusinessException("CreditCode $creditCode not fund"))

        return  if(credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
    }
}
