package eksamen2021;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Underviser{

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int undervisnings_nr;


@ManyToOne
@JoinColumn(name = "kode", referencedColumnName = "undervisnings_nr")
    private Fag fag;

@ManyToOne
@JoinColumn(name = "id", referencedColumnName = "undervisnings_nr")
    private Person person;

}
