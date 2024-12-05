package com.eazyBank.accounts.constants;

public class AccountsConstants {


    private AccountsConstants(){
//restrict instantiation in this class i just
  //  want to handle constants and i don't want
    //someone polluting this class with some methods or any other business logic
    //that's the reason i created this private constructor

}

//we can use these variable without creating object of this class
    public static final String SAVINGS="Savings";
    public static final String ADDRESS="123 Main Street ,New York";
    public static final String STATUS_201="201";
    public static final String MESSAGE_201="Account created Successfully";
    public static final String STATUS_200="200";
    public static final String MESSAGE_200="Request processed successfully";
    public static final String STATUS_500="500";
    public static final String MESSAGE_500="An error occurred.Please try again or contact Dev team";
    public static final String STATUS_417="417";
    public static final String MESSAGE_417_UPDATE="Update operation failed.Please try again and contact to Dev team";
    public  static final String MESSAGE_417_DELETE="Delete operation failed.Please try again and contact to Dev team";
}
