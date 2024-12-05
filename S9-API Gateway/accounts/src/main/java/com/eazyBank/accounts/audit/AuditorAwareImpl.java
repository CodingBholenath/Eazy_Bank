package com.eazyBank.accounts.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component("auditAwareImpl")
public class AuditorAwareImpl  implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("ACCOUNTS_MS");
        /*
        So,this is the value that i want to be considered by
        the spring data jpa framework whenever it is trying to popoulate
        created by or updated by
         */
    }
}
