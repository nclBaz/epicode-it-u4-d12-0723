package riccardogulin.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import riccardogulin.entities.Student;

public class StudentsDAO {
	// DAO (Data Access Object) è un Design Pattern. Questa classe ci serve per
	// nascondere i dettagli implementativi dei metodi che accederanno al db, che in alcuni
	// casi potrebbero essere anche abbastanza complessi. Nascondendoli quindi forniamo al main
	// e a chiunque avrà bisogno di interagire col db, dei metodi pratici e semplici da utilizzare
	// magari anche con dei nomi "parlanti"
	private final EntityManager em;

	public StudentsDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Student student){
		// 0. Richiedo all'entity manager una nuova transazione
		EntityTransaction transaction = em.getTransaction();

		// 1. Inizio la transazione
		transaction.begin();

		// 2. Aggiungo lo studente al Persistence Context (in questo momento non l'ho ancora effettivamente salvato nel DB)
		em.persist(student);

		// 3. Concludo la transazione con l'effettivo salvataggio a db
		transaction.commit();
		System.out.println("Studente " + student.getName() + " salvato correttamente!");
	}

/*	public Student findById(long studentId){}*/

	public void findByIdAndDelete(long studentId){}
}
