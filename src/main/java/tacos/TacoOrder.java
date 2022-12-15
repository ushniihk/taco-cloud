package tacos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;
import lombok.Data;


@Data
@Table(name = "Taco_Order")
@Entity
public class TacoOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "delivery_Name")
    @NotBlank(message = "Delivery name is required")
    private String deliveryName;
    @Column(name = "delivery_Street")
    @NotBlank(message = "Street is required")
    private String deliveryStreet;
    @Column(name = "delivery_City")
    @NotBlank(message = "City is required")
    private String deliveryCity;
    @Column(name = "delivery_State")
    @NotBlank(message = "State is required")
    private String deliveryState;
    @Column(name = "delivery_Zip")
    @NotBlank(message = "Zip code is required")
    private String deliveryZip;
    @Column(name = "cc_number")
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Column(name = "cc_expiration")
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Column(name = "cc_cvv")
    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    private String ccCVV;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Taco> tacos = new ArrayList<>();
    @Column(name = "placed_at")
    private Date placedAt = new Date();
    @ManyToOne
    private User user;

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}