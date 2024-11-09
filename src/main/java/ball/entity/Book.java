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
@Table(name = "Books")
@NamedQuery(name = "Book.findAll", query = "Select b from Book b")
public class Book {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "bookid")
        private int id;


        private int isbn;

        @Column(name = "title", columnDefinition = "nvarchar(200)")
        private String title;

        @Column(name = "publisher", columnDefinition = "nvarchar(100)")
        private String publisher;

        @Column(name = "price", columnDefinition = "decimal(6,2)")
        private Double price; // Sử dụng Double để có thể là null

        @Column(name = "description", columnDefinition = "text")
        private String description;

        @Column(name = "publish_date", columnDefinition = "Date")
        private Date publishdate; // Sử dụng java.sql.Date để lưu trữ ngày tháng từ CSDL

        @Column(name = "cover_image", columnDefinition = "nvarchar(1000)")
        private String coverimage;

        private int quantity;



}
