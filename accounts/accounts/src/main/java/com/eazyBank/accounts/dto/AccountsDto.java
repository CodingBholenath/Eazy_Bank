package com.eazyBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name="Accounts",
        description = "Schema to hold Accounts information"
)
public class AccountsDto {
    @Schema(
            description = "Account Number of the customer"
    )
    @Pattern(regexp = "[0-9]{10}", message = "Mobile number should be 10 digits")

    private Long accountNumber;

    @Schema(description = "Account Type of the customer",
    example="SAVINGS")
@NotEmpty(message = "Account Type cannot be a  null or empty")
    private String accountType;

    @Schema(description = "Branch Address of the customer")
@NotEmpty(message = "Branch Address cannot be a  null or empty")
    private String branchAddress;
}
