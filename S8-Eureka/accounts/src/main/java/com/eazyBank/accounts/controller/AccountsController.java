package com.eazyBank.accounts.controller;

import com.eazyBank.accounts.constants.AccountsConstants;
import com.eazyBank.accounts.dto.AccountsContactInfoDto;
import com.eazyBank.accounts.dto.CustomerDto;
import com.eazyBank.accounts.dto.ErrorResponseDto;
import com.eazyBank.accounts.dto.ResponseDto;
import com.eazyBank.accounts.service.IAccountsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name="CRUD REST API for Accounts in EazyBank",
        description = "CRUD REST API for Accounts in EazyBank to CREATE,UPDATE,FETCH AND DELETE account details")
@RestController
@RequestMapping(path="/api",produces= MediaType.APPLICATION_JSON_VALUE)
//@AllArgsConstructor
/*
With this allargsConstructor AccountsController
is going to have the constructor that accpets
the IAccountService as the parameter
 */
@Validated

public class AccountsController {

//   @GetMapping("/sayHello")
//    public String sayHello(){
//       return "Hello World";
//   }

    private  final IAccountsService iAccountsService;

    public AccountsController(IAccountsService iAccountsService) {
              this.iAccountsService = iAccountsService;
            }
    @Value("${build.version}")
    private String buildVersion;
@Autowired
    private Environment environment;

@Autowired
private AccountsContactInfoDto accountsContactInfoDto;
@Operation(summary = "Create a new account Rest api",
        description = "REST API to Create a new  customer & account inside EazyBank")
@ApiResponses({
        @ApiResponse(
                responseCode = "201",
                description = " HTTP Status CREATED"),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP Status Internal Server Error",
                content = @Content(
                    schema = @Schema(implementation = ErrorResponseDto.class)
                )
        )
})


    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto){
iAccountsService.createAccount(customerDto);
    return ResponseEntity.
            status(HttpStatus.CREATED)
            .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
}
@Operation(summary = "Fetch account details Rest api",
        description = "REST API to fetch account details inside EazyBank")
@ApiResponses({
        @ApiResponse(
                responseCode = "200", description = " HTTP Status OK"),
        @ApiResponse(
                responseCode = "500",
                description = "HTTP Status Internal Server Error",
                content = @Content(
                        schema = @Schema(implementation = ErrorResponseDto.class)
                )
        )
})
@GetMapping("/fetch")
public ResponseEntity<CustomerDto>fetchAccountDetails(@RequestParam @Pattern(regexp = "[0-9]{10}",message = "The length of number should be 10")
                                                      String mobileNumber) {
CustomerDto customerDto=iAccountsService.fetchAccount(mobileNumber);

return ResponseEntity.status(HttpStatus.OK).body(customerDto);


}
@Operation(summary = "Update account details Rest api",
        description = "REST API to update account details inside EazyBank")
@ApiResponses({
@ApiResponse(
        responseCode = "200",
        description = "HTTP Status OK"
),
        @ApiResponse(
                responseCode = "417",
                description = "Exception failed to update account details"
        ),
@ApiResponse(
        responseCode = "500",
        description = "HTTP Status Internal Server Error",
        content = @Content(
                schema =   @Schema(implementation = ErrorResponseDto.class)
        )
)
})
@PutMapping("/update")
    public ResponseEntity<ResponseDto>updateAccountDetails(@Valid @RequestBody CustomerDto customerDto){

        boolean isUpdated=iAccountsService.updateAccount(customerDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountsConstants.STATUS_200,AccountsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_UPDATE));

        }
}
@Operation(summary = "Delete account details Rest api",
        description = "REST API to delete account details inside EazyBank")
@ApiResponses({
@ApiResponse(
        responseCode ="200",
        description = "HTTP Status OK"
),
        @ApiResponse(
                responseCode = "417",
                description = "Exception failed to delete account details"
        ),
        @ApiResponse
                (
                        responseCode = "500",
                        description = "HTTP Status Internal Server Error",
                        content = @Content(
                                schema =   @Schema(implementation = ErrorResponseDto.class)
                        )
                )


})
@DeleteMapping("/delete")

    public ResponseEntity<ResponseDto>deleteAccountDetails(@RequestParam  @Pattern(regexp = "[0-9]{10}",message = "The length of number should be 10")
                                                           String mobileNumber) {
    boolean isDeleted = iAccountsService.deleteAccount(mobileNumber);
    if (isDeleted) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
    } else {
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body(new ResponseDto(AccountsConstants.STATUS_417, AccountsConstants.MESSAGE_417_DELETE));
    }
}
    @Operation(summary = "Get build info Rest api",
            description = "Get Build information that is deployed into account microservice")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200", description = " HTTP Status OK"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
@GetMapping("/build-info")
public ResponseEntity<String> getBuildInfo(){
    return ResponseEntity
            .status(HttpStatus.OK)
            .body(buildVersion);
}
    @Operation(summary = "Get Java version" ,
            description = "Get Java version details that is installed into accounts microservices")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200", description = " HTTP Status OK"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }
    @Operation(summary = "Get Contact Info" ,
            description = "Contact Info details that is installed into can be reached out in case of any issue")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200", description = " HTTP Status OK"),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    })
    @GetMapping("/contact-info")
    public ResponseEntity<AccountsContactInfoDto> getJContactInfo(){
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountsContactInfoDto);
    }


}
