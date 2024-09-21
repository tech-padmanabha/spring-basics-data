package io.pn;

import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

@Component("auditAwareImpl")
public class AuditAwareImpl implements AuditorAware<String>{

	@Override
	public Optional<String> getCurrentAuditor() {
		return Optional.ofNullable("PADMANABHA");
	}
	
	// at the time of working with security we should work with this
//	@Override
//	public Optional<String> getCurrentAuditor() {
//		return Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication().getName());
//	}

}
