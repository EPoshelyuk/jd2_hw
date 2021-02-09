package it.academy.pojos;


import it.academy.pojos.IAddress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@PropertySource("classpath:address.properties")
public class FirstAddress implements IAddress {

    private Long id;

    @Value("${address.country}")
    private String country;

    @Value("${address.city}")
    private String city;

    @Value("${address.street}")
    private String street;

    @Value("${address.home}")
    private Long home;
}
