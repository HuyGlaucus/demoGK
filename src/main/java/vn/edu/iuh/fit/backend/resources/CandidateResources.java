package vn.edu.iuh.fit.backend.resources;

import jakarta.annotation.Resources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import vn.edu.iuh.fit.backend.service.CandidateService;

@RestController("/api/vi")
public class CandidateResources {
    @Autowired
    private CandidateService services;
}