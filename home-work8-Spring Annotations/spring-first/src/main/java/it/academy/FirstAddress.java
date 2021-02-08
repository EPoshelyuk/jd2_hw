package it.academy;


import it.academy.pojos.IAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FirstAddress implements IAddress {

    private Long id;
    private String country;
    private String city;
    private String street;
    private Long home;
}
