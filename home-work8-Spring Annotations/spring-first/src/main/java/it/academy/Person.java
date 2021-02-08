package it.academy;

import it.academy.pojos.IAddress;
import it.academy.pojos.IEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Person {

    private Integer id;

    private Integer age;

    private String name;

    private String surname;

    @Autowired(required = false)
    @Qualifier("firstAddress")
    private IAddress address;

   //@Autowired
    private IEmail email;

}
