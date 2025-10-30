package com.davidev.controller.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
    private final String title;
    private final int status;
    private final String details;
    private final URI instance;
    @JsonProperty("trace-id")
    private final String traceId;
    private final URI path;
    private final LocalDateTime timestamp;
    private final List<Error> errors;

    public String getTitle() {
        return title;
    }

    public int getStatus() {
        return status;
    }

    public String getDetails() {
        return details;
    }

    public URI getInstance() {
        return instance;
    }

    public String getTraceId() {
        return traceId;
    }

    public URI getPath() {
        return path;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public List<Error> getErrors() {
        return List.copyOf(errors);
    }

    public static class Error{
        private String field;
        private String code;
        private String message;

        public Error(String field, String code, String message) {
            this.field = field;
            this.code = code;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    private ErrorResponse(String title, int status, String details, URI instance, String traceId, URI path, LocalDateTime timestamp, List<Error> errors) {
        this.title = Objects.requireNonNull(title,"title cannot be null");
        this.status = status;
        this.details = details;
        this.instance = Objects.requireNonNull(instance, "instance cannot be null");
        this.traceId = traceId;
        this.path = Objects.requireNonNull(path, "path cannot be null");
        this.timestamp = timestamp;
        this.errors = errors;
    }

    public static ApiResponseBuilder builder(){
        return new ApiResponseBuilder();
    }

    public static class ApiResponseBuilder {
        private String title;
        private int status;
        private String details;
        private URI instance;
        private String traceId;
        private URI path;
        private LocalDateTime timestamp= LocalDateTime.now();
        private List<Error> errors= new ArrayList<>();

        public ApiResponseBuilder withTitle(String title){
            this.title = title;
            return this;
        }
        public ApiResponseBuilder withStatus(int status){
            this.status = status;
            return this;
        }
        public ApiResponseBuilder withDetails(String details){
            this.details = details;
            return this;
        }
        public ApiResponseBuilder withInstance(URI instance){
            this.instance = instance;
            return this;
        }
        public ApiResponseBuilder withTraceId(String traceId){
            this.traceId = traceId;
            return this;
        }
        public ApiResponseBuilder withPath(URI path){
            this.path = path;
            return this;
        }
        public ApiResponseBuilder withTimestamp(LocalDateTime timestamp){
            this.timestamp = timestamp;
            return this;
        }
        public ApiResponseBuilder withErrors(List<Error> errors){
            this.errors = new ArrayList<>(errors);
            return this;
        }
        public ApiResponseBuilder addError(String field, String code, String message){
            this.errors.add(new Error(field, code, message));
            return this;
        }
        public ErrorResponse build(){
            if(status <200 || status>599){
                throw new IllegalArgumentException("Status must be between 200 and 599");
            }
            return new ErrorResponse(title,status,details,instance,traceId,path,timestamp,errors);
        }
    }
}
