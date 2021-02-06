package it.academy.pojos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "PASSPORT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passport {

    @Id
    // @Column(name = "P_NUMBER")
    private String passportNumber;

    // @Column(name = "P_ISSUEDDATE")
    private Date issuedDate;

    // @Column(name = "P_EXPIRYDATE")
    @Access(AccessType.FIELD)
    public Date expiryDate;

    @Transient
    @Access(AccessType.PROPERTY)
    public Date loginTime;

}




