package ball.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "book_author")
public class BookAuthor {
        @Id
        @ManyToOne
        @JoinColumn(name = "bookid") // Không dùng insertable = false, updatable = false
        private Book book;

        @Id
        @ManyToOne
        @JoinColumn(name = "author_id") // Không dùng insertable = false, updatable = false
        private Author author;
}
