package io.pn.repository.inheritance;

import io.pn.entity.inheritance.mappedsuperclass.Bike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeRepository extends JpaRepository<Bike,Integer> {
}
