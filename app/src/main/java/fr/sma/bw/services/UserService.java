package fr.sma.bw.services;

import fr.sma.svc.bw.userservice.model.ListUserResponse;
import fr.sma.bw.entities.User;
import fr.sma.bw.mappers.ObjectMapperUtils;
import fr.sma.bw.repositories.mybatis.UserDao;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    private final UserDao userDao;
    private ObjectMapperUtils objectMapperUtils;
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }
    public ListUserResponse retrieveUsers() {
        List<User> reponseDTO  = this.userDao.getListUsers();
        List<fr.sma.svc.bw.userservice.model.User> listUers  =
        objectMapperUtils.mapAll(reponseDTO, fr.sma.svc.bw.userservice.model.User.class);
        ListUserResponse out = new ListUserResponse();
        out.addAll(listUers);
        return out;
    }
}
