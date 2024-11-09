package ball.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Author")
public class Author {
        @Id
        @Column(name = "author_id")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int authorId;

        @Column(name = "author_name", columnDefinition = "nvarchar(100)")
        private String authorname;

        @Column(name = "date_of_birth")
        private Date dateofbirth;

}
