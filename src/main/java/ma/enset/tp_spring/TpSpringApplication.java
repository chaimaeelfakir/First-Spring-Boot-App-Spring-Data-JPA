package ma.enset.tp_spring;

import ma.enset.tp_spring.entities.patient;
import ma.enset.tp_spring.repository.patientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class TpSpringApplication implements CommandLineRunner {
     @Autowired
     private patientRepository patientRepository ;
    public static void main(String[] args) {
        SpringApplication.run(TpSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // patientRepository.save(new patient(null,"aya",new Date(),true,123));
       // patientRepository.save(new patient(null,"hanae",new Date(),true,243));
        List<patient> patients= patientRepository.findAll();
        for (patient p:patients) {
            System.out.println(p.toString());
        }
        System.out.println("----------------------");
        patient p=patientRepository.findById(Long.valueOf(1)).get();
        System.out.println(p.toString());
        System.out.println("---------------------");
       List<patient> patientList=patientRepository.findByNomContains("a");
        for (patient p1:patientList) {
            System.out.println(p1.toString());
        }

    System.out.println("--------------------------");
     List<patient> patients1=patientRepository.findByScoreGreaterThan(200);
        for (patient p2:patients1) {
            System.out.println(p2.toString());
        }
    }
}
