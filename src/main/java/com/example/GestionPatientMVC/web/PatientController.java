package com.example.GestionPatientMVC.web;

import com.example.GestionPatientMVC.entities.Patient;
import com.example.GestionPatientMVC.repositories.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientrepository;

    @GetMapping(path = "/index")
    public String patients(Model model,
                           @RequestParam(name = "page", defaultValue = "0") int page, // num de page par defaut
                           @RequestParam(name = "size", defaultValue = "5") int size, // taille de chaque page
                           @RequestParam(name = "keyword", defaultValue = "") String keyword) { // parametre keyword recupéré a partir du formulaire
        Page<Patient> pagepatients = patientrepository.findByNomContains(keyword, PageRequest.of(page, size));
        model.addAttribute("ListePatients", pagepatients.getContent()); // avoir contenu de chaque page
        model.addAttribute("pages", new int[pagepatients.getTotalPages()]); // tableau pour pagination
        model.addAttribute("currentPage", page); // stocker page courante
        model.addAttribute("keyword", keyword); // avoir tous les patients
        return "patients";
    }

    @GetMapping(path = "/delete")
    public String delete(Long id, String keyword, int page) {
        patientrepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }


}
