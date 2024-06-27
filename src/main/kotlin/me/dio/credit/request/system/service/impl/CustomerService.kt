package me.dio.credit.request.system.service.impl

import me.dio.credit.request.system.entity.Customer
import me.dio.credit.request.system.exception.BusinessException
import me.dio.credit.request.system.service.ICustomerService
import me.dio.credit.request.system.repositories.CustomerRepository
import org.springframework.stereotype.Service

@Service
class CustomerService(private  val customerRepository: CustomerRepository) : ICustomerService {

    override fun save(customer: Customer): Customer {
        return this.customerRepository.save(customer);
    }

    override fun findById(id: Long): Customer {
        return this.customerRepository.findById(id).orElseThrow{
            throw BusinessException("Id $id not found")
        };
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.customerRepository.delete(customer)
    }
}