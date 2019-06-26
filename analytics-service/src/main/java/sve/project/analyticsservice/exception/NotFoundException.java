package sve.project.analyticsservice.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

public class NotFoundException extends RuntimeException implements GraphQLError {
    public NotFoundException(String message) {
        super(message);
    }
    public NotFoundException(Long id, String type) {
        super(type + " with ID:'" + id.toString() + "' not found.");
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.ValidationError;
    }

    @JsonIgnore
    @Override
    public StackTraceElement[] getStackTrace() {
        return super.getStackTrace();
    }
}
