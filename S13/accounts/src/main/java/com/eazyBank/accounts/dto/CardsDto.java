package com.eazyBank.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Schema(name = "Cards",
        description = "Schema to hold Card information"
)
@Data
public class CardsDto {
    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp = "[0-9]{10}", message = "Mobile number should be 10 digits")
    @Schema(description = "Mobile Number of Customer",
    example = "8959778998")
    private String mobileNumber;

    @NotEmpty(message = "Card Number can not be a null or empty")
    @Pattern(regexp = "[0-9]{12}", message = "Card number should be 12 digits")
   @Schema(description =
           "Card Number of the customer",example = "123456789012")
    private String cardNumber;
    @NotEmpty(message = "Card Type can not be a null or empty")
    @Schema(
            description = "Type of the card",example = "Credit Card"
    )
    private String cardType;

    @Positive(message = "Total card limit should be a greater than zero")
    @Schema(description = "Total card limit of the customer",example = "10000")
    private int totalLimit;

    @PositiveOrZero(message = "Total amount used should be equal or greater than zero")
    @Schema(
            description = "Total amount used by the customer",example = "5000"
    )
    private int amountUsed;
    @PositiveOrZero(message = "Total available amount should be equal or greater than zero")
    @Schema(
            description = "Total available amount of the customer",example = "5000"
    )
    private int availableAmount;
}
