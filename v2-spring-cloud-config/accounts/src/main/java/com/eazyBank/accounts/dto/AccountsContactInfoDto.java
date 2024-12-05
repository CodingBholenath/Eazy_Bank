package com.eazyBank.accounts.dto;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
//public record AccountsContactInfoDto(
//        String message, Map<String,String> contactDetails, List<String> onCallSupport) {
//Whenever you are using record, you don't need to write the constructor.,all your
//field are going to be final pnce object is created with the help of constructor.then there is no way to
//change the value inside the fields so we are now using class.

//}

@Getter
@Setter

public class AccountsContactInfoDto {

    private String message;

    private Map<String,String> contactDetails;

    private List<String> onCallSupport;
}
