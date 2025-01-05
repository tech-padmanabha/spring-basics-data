package io.pn.repository;

import io.pn.entity.BookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookLogRepository extends JpaRepository<BookLog,Long> {

}
