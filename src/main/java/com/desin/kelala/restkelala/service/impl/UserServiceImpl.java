package com.desin.kelala.restkelala.service.impl;

import com.desin.kelala.restkelala.authentihication.MyUserDetails;
import com.desin.kelala.restkelala.entity.User;
import com.desin.kelala.restkelala.repository.UserRepository;
import com.desin.kelala.restkelala.response.Answer;
import com.desin.kelala.restkelala.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);
        if(user == null){
            LOG.info("No se puedo obtener el usuario");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getMenu())));
        UserDetails userDetails = new MyUserDetails(user, new HashSet<>(authorities));
        return userDetails;
    }

    @Override
    public Answer saveUser(User user) {
        LOG.info("[userServiceImpl][saveUser] -> Inicio");
        Answer answer = new Answer();
        answer.setCode("OK");
        answer.setMessage("Usuario registrado satisfactoriamente");
        try{
            if(user != null && !user.getEmail().equals("") && user.getEmail() != null){
                User userInsert = userRepository.save(user);
                if(userInsert == null){
                    answer.setCode("NOK");
                    answer.setMessage("Problemas al ingresar el usuario, error de comunicación");
                }
            }
            else {
                answer.setCode("NOK");
                answer.setMessage("Problemas al ingresar el usuario, email nulo");
            }
        }catch (Exception e){
            LOG.info(e.getMessage());
            answer.setCode("NOK");
            answer.setMessage("Problemas al ingresar el usuario");
        }
        LOG.info("[userServiceImpl][saveUser] -> Fin");
        return answer;
    }
}
