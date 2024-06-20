package me.dio.credit.request.system.contoller

import me.dio.credit.request.system.DTO.Credit.CreditDTO
import me.dio.credit.request.system.DTO.Credit.CreditView
import me.dio.credit.request.system.DTO.Credit.CreditViewList
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.service.impl.CreditService
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun savaCredit(@RequestBody creditDTO: CreditDTO):String{
       val credit: Credit =  this.creditService.save(creditDTO.toEntity())
        return "Credit ${credit.credtCode} - Customer ${credit.customer?.firstName} saved!"
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): List<CreditViewList>{
        return this.creditService.findAllByCustomer(customerId).stream()
                .map { credit: Credit-> CreditViewList(credit) }.collect(Collectors.toList())
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value =  "customerId" ) customerId: Long,@PathVariable creditCode: UUID ): CreditView {

        val credit :Credit = this.creditService.findByCreditCode(customerId,creditCode)
        return CreditView(credit)
    }
}