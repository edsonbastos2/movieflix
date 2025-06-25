package com.edsonBastos.catalog.mapper;

import com.edsonBastos.catalog.controller.request.StreamingRequest;
import com.edsonBastos.catalog.controller.response.StreamingResponse;
import com.edsonBastos.catalog.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest request) {
        return Streaming
                .builder()
                .name(request.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming request) {
        return StreamingResponse
                .builder()
                .id(request.getId())
                .name(request.getName())
                .build();
    }
}
