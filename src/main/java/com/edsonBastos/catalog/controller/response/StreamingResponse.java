package com.edsonBastos.catalog.controller.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id, String name) {
}
