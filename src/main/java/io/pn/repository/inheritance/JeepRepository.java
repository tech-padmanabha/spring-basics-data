package io.pn.repository.inheritance;

import io.pn.entity.inheritance.mappedsuperclass.Jeep;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JeepRepository extends JpaRepository<Jeep,Integer> {

}
