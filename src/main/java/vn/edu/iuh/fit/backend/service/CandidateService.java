package vn.edu.iuh.fit.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.reposritory.CandidateRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<Candidate> getCandidatesByCompany(String companyName) {
        return candidateRepository.findCandidatesByCompanyName(companyName);
    }
    public List<Candidate> getExperiencedCandidates(int i) {
        return candidateRepository.findExperiencedCandidates(i);
    }
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Optional<Candidate> getCandidateById(long id) {
        return candidateRepository.findById(id);
    }

    public Candidate addCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    public Candidate updateCandidate(long id, Candidate updatedCandidate) {
        Optional<Candidate> existingCandidate = candidateRepository.findById(id);
        if (existingCandidate.isPresent()) {
            Candidate candidateToUpdate = existingCandidate.get();
            candidateToUpdate.setFullName(updatedCandidate.getFullName());
            candidateToUpdate.setEmail(updatedCandidate.getEmail());
            candidateToUpdate.setPhone(updatedCandidate.getPhone());
            candidateToUpdate.setExperiences(updatedCandidate.getExperiences());

            return candidateRepository.save(candidateToUpdate);
        } else {
            return null;
        }
    }

    public void deleteCandidate(long id) {
        candidateRepository.deleteById(id);
    }


}
