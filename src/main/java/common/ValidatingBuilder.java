package common;

import application.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.Set;

public abstract class ValidatingBuilder {
    private static final Logger LOG = LoggerFactory.getLogger(ValidatingBuilder.class);

    protected Event validate(Event event) {
        Set<ConstraintViolation<Event>> violations = Validation.buildDefaultValidatorFactory().getValidator().validate(event);
        if (!violations.isEmpty()) {
            violations.forEach(violation -> LOG.warn("Class : {}, Property : {}, Violation : {}",
                    violation.getRootBeanClass(), violation.getPropertyPath(), violation.getMessage()));
            throw new IllegalArgumentException(violations.toString());
        }
        return event;
    }

}
