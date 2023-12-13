package vn.edu.iuh.fit.backend.reposritory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vn.edu.iuh.fit.backend.models.Candidate;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate,Long> {

    @Query("SELECT c FROM Candidate c JOIN Experience e ON c.id = e.candidate.id WHERE e.fromDate <= CURRENT_DATE - INTERVAL :years YEAR")
    List<Candidate> findExperiencedCandidates(@Param("years") int years);
    @Query("SELECT DISTINCT c FROM Candidate c JOIN Experience e ON c.id = e.candidate.id WHERE e.companyName = :companyName")
    List<Candidate> findCandidatesByCompanyName(@Param("companyName") String companyName);
}
