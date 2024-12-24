package io.pn.dto;

import java.time.LocalDateTime;
import java.util.List;

public record ErrorDetails(
        LocalDateTime date,
        String description,
        List<String> errors) {
}
