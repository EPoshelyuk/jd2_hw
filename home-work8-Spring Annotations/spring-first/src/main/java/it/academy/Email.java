package it.academy;

import it.academy.pojos.IEmail;
import it.academy.util.AddDuringScan;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@AddDuringScan
public class Email implements IEmail {

    private Long id;
    private String login;
    private String password;

}
