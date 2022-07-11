package model;


import enums.Country;
import enums.DateOfBirth;
import enums.State;
import lombok.Data;

@Data
public class RegisterForm {

    private DateOfBirth dateOfBirth;
    private State state;
    private Country country;
    private String firstNameCustomer;
    private String lastNameCustomer;
    private String email;
    private String password;
    private String company;
    private String address;
    private String city;
    private String postalCode;
    private String additionalInformation;
    private String homePhone;
    private String mobilePhone;
    private String addressAlias;

}
