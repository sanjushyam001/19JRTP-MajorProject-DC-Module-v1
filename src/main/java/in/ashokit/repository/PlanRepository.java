package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ashokit.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
