package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Income;

public interface IncomeRepository extends JpaRepository<Income, Integer> {

}
