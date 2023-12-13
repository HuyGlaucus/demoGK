package vn.edu.iuh.fit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Experience;
import vn.edu.iuh.fit.backend.reposritory.ExperienceRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ExperienceService {

    @Autowired
    private ExperienceRepository experienceRepository;

    public List<Experience> getAllExperiences() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getExperienceById(long id) {
        return experienceRepository.findById(id);
    }

    public Experience addExperience(Experience experience) {
        return experienceRepository.save(experience);
    }

    public Experience updateExperience(long id, Experience updatedExperience) {
        Optional<Experience> existingExperience = experienceRepository.findById(id);
        if (existingExperience.isPresent()) {
            Experience experienceToUpdate = existingExperience.get();
            // Update relevant fields
            experienceToUpdate.setWorkDescription(updatedExperience.getWorkDescription());
            experienceToUpdate.setCompanyName(updatedExperience.getCompanyName());
            experienceToUpdate.setRole(updatedExperience.getRole());
            experienceToUpdate.setCandidate(updatedExperience.getCandidate());
            experienceToUpdate.setFromDate(updatedExperience.getFromDate());
            experienceToUpdate.setToDate(updatedExperience.getToDate());

            return experienceRepository.save(experienceToUpdate);
        } else {
            return null; // Experience with the given ID not found
        }
    }

    public void deleteExperience(long id) {
        experienceRepository.deleteById(id);
    }
}