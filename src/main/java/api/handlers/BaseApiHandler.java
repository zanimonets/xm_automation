package api.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class BaseApiHandler {
    protected final ObjectMapper objectMapper = new ObjectMapper();
}
