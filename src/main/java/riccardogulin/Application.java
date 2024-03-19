package riccardogulin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import riccardogulin.dao.StudentsDAO;
import riccardogulin.entities.Student;
import riccardogulin.entities.StudentType;
import riccardogulin.exceptions.NotFoundException;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d12");
    // Il parametro di createEntityManagerFactory DEVE corrispondere precisamente a quanto indicato nel persistence.xml (persistence-unit)
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        StudentsDAO sd = new StudentsDAO(em);

/*        Student aldo = new Student("Aldo", "Baglio", StudentType.BACKEND);
        Student giovanni = new Student("Giovanni", "Storti", StudentType.FRONTEND);
        Student giacomo = new Student("Giacomo", "Poretti", StudentType.FULLSTACK);*/

        // ************************************* SAVE *************************************
 /*       sd.save(aldo);
        sd.save(giovanni);
        sd.save(giacomo);*/
        try {
            Student aldo = sd.findById(11);
            System.out.println(aldo);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            sd.findByIdAndDelete(3);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        // Anche se nelle nostre applicazioni non è espressamente richiesto, sarebbe sempre bene alla fine di tutto
        // chiudere entitymanager & factory
        em.close();
        emf.close();
    }
}
