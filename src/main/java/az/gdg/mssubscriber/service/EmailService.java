package az.gdg.mssubscriber.service;

import az.gdg.mssubscriber.model.dto.MailDTO;

public interface EmailService {

    void sendToQueue(MailDTO mailDTO);
}
