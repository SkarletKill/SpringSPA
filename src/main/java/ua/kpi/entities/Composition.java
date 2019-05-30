package ua.kpi.entities;

import lombok.Data;
import javax.persistence.*;

@Data
@Table(name = "composition")
@Entity
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int duration;

    @ManyToOne
    @JoinColumn( name = "composer", nullable = false)
    private Composer composer;

    public Composition() {}

    public Composition(String name, int duration, Composer composer) {
        setName(name);
        setDuration(duration);
        setComposer(composer);
    }

    public Composition(Long id, String name, int duration, Composer composer) {
        setId(id);
        setName(name);
        setDuration(duration);
        setComposer(composer);
    }
}
