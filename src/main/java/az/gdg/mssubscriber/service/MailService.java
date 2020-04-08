package az.gdg.mssubscriber.service;

import az.gdg.mssubscriber.model.dto.MailDTO;

public interface MailService {

    void sendToQueue(MailDTO mailDTO);
}
