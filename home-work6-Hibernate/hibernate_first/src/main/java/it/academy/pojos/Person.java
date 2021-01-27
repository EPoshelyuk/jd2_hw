package it.academy.pojos;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "T_PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {
    @Id
    @GeneratedValue
    @Column(name = "P_ID")
    private Integer id;

    @Column (name = "P_AGE")
    private Integer age;

    @Column (name = "P_NAME")
    private String name;

    @Column (name = "P_SURNAME")
    private String surname;
}
