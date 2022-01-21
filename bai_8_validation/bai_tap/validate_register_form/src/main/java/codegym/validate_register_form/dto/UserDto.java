package codegym.validate_register_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;

public class UserDto implements Validator {
    private Long id;
    @NotBlank(message = "no blanks or spaces")
    @Size(min = 5, max = 45, message = "Name must have at least 5 characters and maximum 45 characters")
    private String firstName;

    @NotBlank(message = "no blanks or spaces")
    @Size(min = 5, max = 45, message = "Name must have at least 5 characters and maximum 45 characters")
    private String lastName;

    private String phoneNumber;

    @NotNull(message = "Blanks are not allowed")
    @Min(value = 18, message = "Age must be more than or equal 18")
    private Integer age;

    @NotEmpty(message = "Email cannot be empty.")
    @Email(message = "not format email")
    private String email;


    public UserDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String phone = userDto.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty","Number must not empty");
        if (phone.length() > 11 || phone.length() < 10) {
            errors.rejectValue("phoneNumber", "phoneNumber.length", "Number must be 10 -11 number");
        }
        if (!phone.startsWith("0")) {
            errors.rejectValue("phoneNumber", "phoneNumber.startsWith", "Number must start with 0");
        }
        if (!phone.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phoneNumber", "phoneNumber.matches", "Phone Must be numbers");
        }
    }
}
