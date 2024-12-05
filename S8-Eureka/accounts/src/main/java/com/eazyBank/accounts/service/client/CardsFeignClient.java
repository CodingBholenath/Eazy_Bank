package com.eazyBank.accounts.service.client;


import com.eazyBank.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cards")
public interface CardsFeignClient {
    @GetMapping(value = "/api/fetch1",consumes = "application/json")
     public ResponseEntity<CardsDto>fetchCardDetails(@RequestParam String  mobileNumber);

}