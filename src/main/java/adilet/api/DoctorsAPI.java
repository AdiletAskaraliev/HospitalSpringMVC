package adilet.api;

import adilet.entity.Doctor;
import adilet.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorsAPI {

    private final DoctorService doctorService;

    @GetMapping("/{hospitalId}")
    String getAllDoctors(@PathVariable("hospitalId") Long hospitalId, Model model){
        model.addAttribute("getAllDoctors", doctorService.findAllDoctors(hospitalId));
        return "doctorHTML/getAll";
    }

    @GetMapping("create/{hospitalId}")
    String createDoctorByHospitalId(@PathVariable Long hospitalId, Model model){
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("newDoctor", new Doctor());
        return "doctorHTML/create";
    }

    @PostMapping("save/{hospitalId}")
    String saveDoctorByHospitalId(@PathVariable("hospitalId") Long hospitalId, @ModelAttribute Doctor doctor){
        doctorService.saveDoctorByHospitalId(hospitalId, doctor);
        return "redirect:/doctors/" + hospitalId;
    }
}
