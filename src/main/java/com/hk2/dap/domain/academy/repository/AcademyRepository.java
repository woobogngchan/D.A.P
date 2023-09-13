package com.hk2.dap.domain.academy.repository;

import com.hk2.dap.domain.academy.entity.Academy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AcademyRepository extends JpaRepository<Academy, Long> {
    Optional<Academy> findByAcademyId(String academyId);

    Optional<Academy> findByAcademyIdAndAcademyPassword(String academyId, String academyPassword);

}
