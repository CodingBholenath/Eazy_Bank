package com.eazyBank.accounts.service.Impl;

import com.eazyBank.accounts.dto.AccountsDto;
import com.eazyBank.accounts.dto.CardsDto;
import com.eazyBank.accounts.dto.CustomerDetailsDto;
import com.eazyBank.accounts.dto.LoansDto;
import com.eazyBank.accounts.entity.Accounts;
import com.eazyBank.accounts.entity.Customer;
import com.eazyBank.accounts.exception.ResouceNotFoundException;
import com.eazyBank.accounts.mapper.AccountsMapper;
import com.eazyBank.accounts.mapper.CustomerMapper;
import com.eazyBank.accounts.repository.AccountRepository;
import com.eazyBank.accounts.repository.CustomerRepository;
import com.eazyBank.accounts.service.ICustomersService;
import com.eazyBank.accounts.service.client.CardsFeignClient;
import com.eazyBank.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResouceNotFoundException("Customer", "Mobile Number", mobileNumber)
        );
        Accounts accounts = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResouceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );
        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts, new AccountsDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;
    }
}
