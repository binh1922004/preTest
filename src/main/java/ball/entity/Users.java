package ball.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@NamedQuery(name = "User.findAll", query = "SELECT u from Users u")
public class Users {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "email", columnDefinition = "varchar(50)")
        private String email;

        @Column(name = "fullname", columnDefinition = "nvarchar(200)")
        private String fullname; // Allows null

        private Integer phone; // Allows null, using Integer instead of int

        @Column(name = "passwd", columnDefinition = "varchar(32)")
        private String passwd;

        @Column(name = "signup_date")
        private Date signupdate; // Allows null

        @Column(name = "last_login")
        private Date lastlogin; // Allows null

        @Column(name = "is_admin")
        private Boolean isadmin; // Allows null, using Boolean instead of boolean

}

