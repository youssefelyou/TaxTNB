package com.example.tax.listeners;

import com.example.tax.bean.Redevable;
import com.example.tax.dto.User;
import com.example.tax.repository.RedevableDao;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @Autowired
    private RedevableDao redevableDao;

    @KafkaListener(topics = "redevable", groupId = "kf-group-1")
    void redevable_listener(String data) {
        System.out.println(data);
        System.out.println("------------------------------");
        User user = new Gson().fromJson(data, User.class);
        System.out.println(user.toString());
        Redevable rd = new Redevable();
        rd.setNom(user.getLastName());
        rd.setPrenom(user.getFirstName());
        rd.setCin(user.getCin());
        redevableDao.save(rd);
    }

}
