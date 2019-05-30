package ua.kpi.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "news")
@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
}
