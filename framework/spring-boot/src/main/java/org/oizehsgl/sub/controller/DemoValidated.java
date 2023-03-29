package org.oizehsgl.sub.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.*;
import org.hibernate.validator.constraints.time.DurationMax;
import org.hibernate.validator.constraints.time.DurationMin;

import java.util.Date;
import java.util.List;

/**
 * demoElement
 *
 * @author oizehsgl
 * @since 4/14/24
 */
@Data
@ScriptAssert(lang = "groovy", script = "_this.range >= 5 && _this.length != null")
public class DemoValidated {
    @Phone
    private String phone;
    @AssertFalse
    private Boolean assertFalse;
    @AssertTrue
    private Boolean assertTrue;
    @Email
    private String email;
    @Pattern(regexp = "^[0x]?[0-9a-fA-F]+$")
    private String pattern;
    @NotBlank
    private String notBlank;
    @NotEmpty
    private String notEmpty;
    @NotNull
    private Object notNul;
    @Null
    private Object aNull;
    @Future
    private Date future;
    @FutureOrPresent
    private Date futureOrPresent;
    @PastOrPresent
    private Date pastOrPresent;
    @Past
    private Date past;
    @Max(9)
    private Integer max;
    @Min(0)
    private Integer min;
    @DecimalMax("")
    private Double decimalMax;
    @DecimalMin("")
    private Double decimalMin;
    @Digits(integer = 0, fraction = 0)
    private Double digits;
    @Positive
    private Integer positive;
    @PositiveOrZero
    private Integer positiveOrZero;
    @NegativeOrZero
    private Integer negativeOrZero;
    @Negative
    private Integer negative;
    @Valid
    @Size(min = 2, max = 4)
    private List<DemoElement> size;


    @Range(min = 2, max = 4)
    private Integer range;
    @Length(min = 2, max = 4)
    private String length;
    @URL
    private String url;
    @UniqueElements
    private List<Integer> uniqueElements;

    @Normalized()
    private String normalized;

    @Mod10Check
    private Integer mod10Check;

    @Mod11Check
    private Integer mod11Check;
    @LuhnCheck
    private String luhnCheck;
    @ISBN
    private String isbn;
    @EAN
    private String ean;
    @Currency({})
    private String currency;
    @CreditCardNumber
    private String creditCardNumber;
    @CodePointLength
    private String codPointLength;
    @DurationMax
    private Date durationMax;
    @DurationMin
    private Date durationMin;

    @ParameterScriptAssert(lang = "groovy", script = "_this.range >= 8 && _this.length != null")
    public void valid() {
    }
}
