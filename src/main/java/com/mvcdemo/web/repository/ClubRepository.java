package com.mvcdemo.web.repository;

import com.mvcdemo.web.models.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ClubRepository extends JpaRepository<Club, Long> {
    Optional<Club> findByTitle(String url);

    @Query("select c FROM Club c where c.title LIKE CONCAT('%', :query, '%')")
    List<Club> searchClubs(String query);
}
