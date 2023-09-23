package springbootcrudjpabuddy.repository;

import java.util.List;

import springbootcrudjpabuddy.entities.Project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("select p from Project p where p.endDate is null")
    List<Project> findActiveProjects();

    List<Project> findByName(String name);
}