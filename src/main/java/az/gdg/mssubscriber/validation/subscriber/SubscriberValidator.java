package az.gdg.mssubscriber.validation.subscriber;


import az.gdg.mssubscriber.model.dto.SubscriberDTO;
import az.gdg.mssubscriber.util.CheckViolationHelper;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class SubscriberValidator implements
        ConstraintValidator<SubscriberConstraint, SubscriberDTO> {

    private final CheckViolationHelper checkViolationHelper;

    public SubscriberValidator(CheckViolationHelper checkViolationHelper) {
        this.checkViolationHelper = checkViolationHelper;
    }

    @Override
    public boolean isValid(SubscriberDTO subscriberDTO, ConstraintValidatorContext context) {
        return subscriberDTO != null &&
                isEmailValid(subscriberDTO.getEmail(), context);
    }

    private boolean isEmailValid(String email, ConstraintValidatorContext context) {
        if (email == null || !email.matches("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?") || email.length() > 254) {
            checkViolationHelper.addViolation(context, "email", "Email is not valid");
            return false;
        }
        return true;
    }
}