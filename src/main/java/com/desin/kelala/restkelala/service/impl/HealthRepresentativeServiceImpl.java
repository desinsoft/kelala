package com.desin.kelala.restkelala.service.impl;

import com.desin.kelala.restkelala.entity.HealthRepresentative;
import com.desin.kelala.restkelala.repository.HealthRepresentativeRepository;
import com.desin.kelala.restkelala.response.Answer;
import com.desin.kelala.restkelala.service.HealthRepresentativeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthRepresentativeServiceImpl implements HealthRepresentativeService {

    private static final Logger LOG = LoggerFactory.getLogger(HealthRepresentativeServiceImpl.class);

    @Autowired
    private HealthRepresentativeRepository healthRepresentativeRepository;

    @Override
    public Answer saveHealthRepresentative(HealthRepresentative healthRepresentative) {
        LOG.info("[HealthRepresentativeServiceImpl][saveHealthRepresentative] -> Inicio");
        Answer answer = new Answer();
        answer.setMessage("Health Representative save successfull");
        answer.setCode("OK");
        try{
            if(healthRepresentative.getName() != null && !healthRepresentative.getName().equals("")){
                LOG.info("[HealthRepresentativeServiceImpl][saveHealthRepresentative] -> save health representative");
                HealthRepresentative insert = healthRepresentativeRepository.save(healthRepresentative);
                if(insert == null){
                    answer.setCode("NOK");
                    answer.setMessage("Problem to save health representative, error comunication");
                }
            }else{
                answer.setCode("NOK");
                answer.setMessage("Request null");
                LOG.info("Request null -> {}");
            }

        }catch (Exception e){
            answer.setCode("NOK");
            answer.setMessage("Problem to save health representativo");
            LOG.info("Problem to save health representativo -> {}", e.getMessage());
        }
        LOG.info("[HealthRepresentativeServiceImpl][saveHealthRepresentative] -> Fin");
        return answer;
    }
}
