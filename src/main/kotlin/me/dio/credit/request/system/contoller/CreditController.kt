package me.dio.credit.request.system.contoller

import me.dio.credit.request.system.DTO.Credit.CreditDTO
import me.dio.credit.request.system.DTO.Credit.CreditView
import me.dio.credit.request.system.DTO.Credit.CreditViewList
import me.dio.credit.request.system.entity.Credit
import me.dio.credit.request.system.service.impl.CreditService
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import java.util.stream.Collectors

@RestController
@RequestMapping("/api/credits")
class CreditController(private val creditService: CreditService) {

    @PostMapping
    fun savaCredit(@RequestBody creditDTO: CreditDTO):ResponseEntity<String>{
       val credit: Credit =  this.creditService.save(creditDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Credit ${credit.credtCode} - Customer ${credit.customer?.firstName} saved!")
    }

    @GetMapping
    fun findAllByCustomerId(@RequestParam(value = "customerId") customerId: Long): ResponseEntity<List<CreditViewList>>{
        val creditViewList : List<CreditViewList> =  this.creditService.findAllByCustomer(customerId).stream()
                .map { credit: Credit-> CreditViewList(credit) }.collect(Collectors.toList())

        return ResponseEntity.status(HttpStatus.OK).body(creditViewList)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(@RequestParam(value =  "customerId" ) customerId: Long,@PathVariable creditCode: UUID ): ResponseEntity<CreditView> {

        val credit :Credit = this.creditService.findByCreditCode(customerId,creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}