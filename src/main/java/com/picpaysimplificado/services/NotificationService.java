package com.picpaysimplificado.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.wesleyvaler.domain.user.User;
import com.picpaysimplificado.dto.NotificationDTO;

@Service
public class NotificationService {
	
    @Autowired
    private RestTemplate restTemplate;
    private NotificationDTO notificationRequest;

    public void sendNotification(User user, String message) throws Exception {
        String Email = user.getEmail();
        notificationRequest = new NotificationDTO(Email, message);

        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("http://o4d9z.mocklab.io/notify", notificationRequest , String.class);

    if(!(notificationResponse.getStatusCode() == HttpStatus.OK )){
        System.out.println("Errro ao enviar notificação");
        throw new Exception("Serviço de notificação fora do ar!!");

    }

    }




}