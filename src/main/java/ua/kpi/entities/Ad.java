package ua.kpi.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "advertisements")
@Entity
public class Ad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String text;

    @ManyToOne()
    @JoinColumn( name = "composition_id", nullable = false)
    private Composition composition;

    public Ad() {
    }

    public Ad(String title, String text, Composition composition) {
        this.title = title;
        this.text = text;
        this.composition = composition;
    }

    public Ad(Long id, String title, String text, Composition composition) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.composition = composition;
    }
}
