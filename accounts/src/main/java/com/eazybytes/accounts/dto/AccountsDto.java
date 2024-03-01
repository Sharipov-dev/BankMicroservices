package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {


    @NotEmpty
    @Pattern(regexp = "(^$|[0-9]{10})", message="AccountNumber must be 10 digits")
    @Schema(
            description = "Account Number of MyBank Account", example = "1234567890"
    )
    private Long accountNumber;

    @NotEmpty(message = "AccountType can not be a null or empty")
    @Schema(
            description = "Account type of MyBank Account", example = "Savings"
    )
    private String accountType;

    @NotEmpty(message = "BranchAddress can not be a null or empty")
    @Schema(
            description = "MyBank branch address", example = "123 New York"
    )
    private String branchAddress;


}
