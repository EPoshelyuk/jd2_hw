package it.academy.pojos;

import it.academy.pojos.IAddress;
import org.springframework.stereotype.Component;

@Component
public class SecondAddress implements IAddress {

    private Long id;
    private String country;
    private String city;
    private String street;
    private Long home;

}
