package club.stefanie.community.service;

import club.stefanie.community.mapper.UserMapper;
import club.stefanie.community.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLoginService {
    @Autowired
    UserMapper userMapper;


    public void updateOrInsert(User user) {
        User dbUser = userMapper.findByAccountId(user.getAccountId());
        if(dbUser == null){
            userMapper.insert(user);
        }
        else{
            dbUser.setAvatarUrl(user.getAvatarUrl());
            dbUser.setToken(user.getToken());
            dbUser.setName(user.getName());
            dbUser.setGmtModified(user.getGmtCreate());
            userMapper.update(dbUser);

        }


    }
}
