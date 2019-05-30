package ua.kpi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@Entity
@Table( name = "composer")
public class Composer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;

    @OneToMany( mappedBy = "composer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Composition> compositions;

    public Composer() {}

    public Composer(String name, String surname, Composition ...compositions) {
        setName(name);
        setSurname(surname);
        this.compositions = Stream.of(compositions).collect(Collectors.toSet());
        this.compositions.forEach(composition -> composition.setComposer(this));
    }

    public Composer(Long id, String name, String surname, Composition ...compositions) {
        setId(id);
        setName(name);
        setSurname(surname);
        this.compositions = Stream.of(compositions).collect(Collectors.toSet());
        this.compositions.forEach(composition -> composition.setComposer(this));
    }
}
