package edu.miu.xavarbnb.validator;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import java.time.LocalDate;

@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = BookingDatesValidator.class)
@Documented
public @interface BookingDates {
	   String message() default "{The check in/out dates are not valid}";

	    Class<?>[] groups() default {};
	    
	    public abstract Class<? extends Payload>[] payload() default {};
	    
}
