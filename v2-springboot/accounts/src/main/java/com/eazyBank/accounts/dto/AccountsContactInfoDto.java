package com.eazyBank.accounts.dto;

import ch.qos.logback.classic.spi.ConfiguratorRank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;
@ConfigurationProperties(prefix = "accounts")
public record AccountsContactInfoDto(
        String message, Map<String,String> contactDetails, List<String> onCallSupport) {
}
