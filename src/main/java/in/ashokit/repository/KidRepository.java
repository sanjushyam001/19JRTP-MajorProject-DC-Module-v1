package in.ashokit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.ashokit.entity.Kid;

@Repository
public interface KidRepository extends JpaRepository<Kid, Integer>{

}
