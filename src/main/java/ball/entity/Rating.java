package ball.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "rating")
public class Rating {
        @Id
        @ManyToOne
        @JoinColumn(name = "userid")
        private Users user;

        @Id
        @ManyToOne
        @JoinColumn(name = "bookid")
        private Book book;

        @Column(name = "rating", columnDefinition = "tinyint")
        private int rating;

        @Column(name = "review_text", columnDefinition = "text")
        private int reviewtext;

}
