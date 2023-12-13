package vn.edu.iuh.fit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.backend.enums.Roles;
import vn.edu.iuh.fit.backend.models.Candidate;
import vn.edu.iuh.fit.backend.models.Experience;
import vn.edu.iuh.fit.backend.reposritory.CandidateRepository;
import vn.edu.iuh.fit.backend.reposritory.ExperienceRepository;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private ExperienceRepository experienceRepository;
    @Bean
    CommandLineRunner initData(){
        addSampleData();
        return null;
    }
    private void addSampleData() {
        Candidate candidate1 = new Candidate(1L, "John Doe", "john.doe@example.com", "123456789");
        Candidate candidate2 = new Candidate(2L, "Jane Doe", "jane.doe@example.com", "987654321");

        Experience experience1 = new Experience(1L, "Software Developer", "ABC Company", Roles.STAFF, candidate1, LocalDate.of(2020, 1, 1), LocalDate.of(2022, 12, 31));
        Experience experience2 = new Experience(2L, "Project Manager", "XYZ Corporation", Roles.MANAGER, candidate2, LocalDate.of(2018, 1, 1), LocalDate.of(2020, 12, 31));

        candidate1.setExperiences(Arrays.asList(experience1));
        candidate2.setExperiences(Arrays.asList(experience2));

        candidateRepository.saveAll(Arrays.asList(candidate1, candidate2));
    }
}
