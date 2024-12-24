package io.pn.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration

// If we work with spring framework then we need to define there configuration
//@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
//@EnableJpaRepositories(basePackages = "io.pn.repository")
//@EntityScan(basePackages = "io.pn.entity")

// here Spring boot handle everything
@EnableJpaAuditing
public class JpaAuditConfiguration {

}
