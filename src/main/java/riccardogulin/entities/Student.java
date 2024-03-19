package riccardogulin.entities;

import jakarta.persistence.*;

@Entity // <-- Mi indica che questa classe dovrà essere mappata ad una tabella nel db
@Table(name = "students") // <-- Serve per personalizzare il nome della tabella (non è obbligatoria)
public class Student {
	@Id // Obbligatoria, ci serve per stabilire chi sarà la chiave primaria della tabella
	@GeneratedValue // Si usa quando si vuol fare gestire automaticamente gli id al database
	// Se non la usassi allora vorrebbe dire che dovrei essere io manualmente ogni volta a dover inserire un valore
	private long id; // Ad es. se uso un long, con @GeneratedValue mi ritroverò ad avere un bigserial come tipo di dato della colonna
	@Column(name = "nome") // Annotazione non obbligatoria, mi serve solo per customizzare il nome della colonna
	private String name;

	@Column(name = "cognome")
	private String surname;
	@Column(name = "tipo")
	@Enumerated(EnumType.STRING) // Di default gli enum vengono convertiti in num interi nella tabella
	// Se voglio che invece essi siano testo allora ho bisogno di usare @Enumerated
	private StudentType studentType;

	public Student() {
		// Se voglio che JPA sia in grado di restituirmi dati dal DB sotto forma di oggetti
		// allora è obbligatorio avere un costruttore vuoto
	}

	public Student(String name, String surname, StudentType studentType) {
		this.name = name;
		this.surname = surname;
		this.studentType = studentType;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public StudentType getStudentType() {
		return studentType;
	}

	public void setStudentType(StudentType studentType) {
		this.studentType = studentType;
	}

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", surname='" + surname + '\'' +
				", studentType=" + studentType +
				'}';
	}
}
