package com.example.GestionPatientMVC;

import com.example.GestionPatientMVC.entities.Patient;
import com.example.GestionPatientMVC.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.xml.crypto.Data;
import java.util.Date;

@SpringBootApplication
public class GestionPatientMvcApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientrepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionPatientMvcApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        patientrepository.save(new Patient(null, "Hamza", new Date(), 100, true));
        patientrepository.save(new Patient(null, "Houssam", new Date(), 100, false));
        patientrepository.save(new Patient(null, "Hatim", new Date(), 100, false));

        patientrepository.findAll().forEach(p -> {
            System.out.println("Patient " + p.getNom());
        });


    }

    //@Bean
//    CommandLineRunner saveUsers(SecurityService securityService) {
//        return args -> {
//            securityService.saveNewUser("hamza", "1234", "1234");
//            securityService.saveNewUser("rayane", "1234", "1234");
//            securityService.saveNewUser("hanaa", "1234", "1234");
//
//            securityService.saveNewRole("ADMIN", "ce role est admin");
//            securityService.saveNewRole("USER", "ce role est user");
//
//            securityService.AddRoleToUser("hamza", "USER");
//            securityService.AddRoleToUser("rayane", "ADMIN");
//            securityService.AddRoleToUser("hanaa", "ADMIN");
//
//        };
//    }
}
