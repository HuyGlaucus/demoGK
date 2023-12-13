package vn.edu.iuh.fit.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.service.CandidateService;
import vn.edu.iuh.fit.backend.service.ExperienceService;

import java.util.List;
import java.util.Optional;

@Controller
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private ExperienceService experienceService;
    @GetMapping("/candidates")
    public String showCandidateList(Model model) {
        model.addAttribute("candidates", candidateService.getAllCandidates());
        return "candidates";
    }
    @GetMapping("/candidates/{id}/details")
    public String getCandidateDetails(@PathVariable long id, Model model) {
        Optional<Candidate> candidateOptional = candidateService.getCandidateById(id);

        if (candidateOptional.isPresent()) {
            Candidate candidate = candidateOptional.get();
            model.addAttribute("candidate", candidate);
            return "cand_details";
        } else {
            return "redirect:/candidates";
        }
    }
    @GetMapping("/report1")
    public String showReport1(Model model, @RequestParam("companyName") String companyName) {
        List<Candidate> candidates = candidateService.getCandidatesByCompany(companyName);
        model.addAttribute("candidates", candidates);
        return "report1";
    }

    @GetMapping("/report2")
    public String showReport2(Model model) {
        List<Candidate> experiencedCandidates = candidateService.getExperiencedCandidates(5);
        model.addAttribute("experiencedCandidates", experiencedCandidates);
        return "report2";
    }

}
