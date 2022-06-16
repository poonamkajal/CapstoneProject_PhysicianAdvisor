package com.perscholas.poonamkajal.physicianadvisor.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import com.perscholas.poonamkajal.physicianadvisor.models.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {


}
