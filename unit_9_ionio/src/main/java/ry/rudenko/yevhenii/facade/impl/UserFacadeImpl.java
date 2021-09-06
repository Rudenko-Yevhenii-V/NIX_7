package ry.rudenko.yevhenii.facade.impl;

import ry.rudenko.yevhenii.dto.UserDto;
import ry.rudenko.yevhenii.entity.User;
import ry.rudenko.yevhenii.facade.UserFacade;
import ry.rudenko.yevhenii.service.SecurityService;
import ry.rudenko.yevhenii.service.UserService;
import ry.rudenko.yevhenii.service.impl.SecurityServiceImpl;
import ry.rudenko.yevhenii.service.impl.UserServiceImpl;

import java.util.List;
import java.util.stream.Collectors;

public class UserFacadeImpl implements UserFacade {

    private final UserService userService = new UserServiceImpl();
    private final SecurityService securityService = new SecurityServiceImpl();

    @Override
    public void register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        userService.create(user);
    }

    @Override
    public void updateByToken(UserDto dto, String token) {
        String userId = securityService.findUserIdByToken(token);
        User user = userService.findById(userId);
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        userService.update(user);
    }

    @Override
    public void deleteByToken(String token) {
        String userId = securityService.findUserIdByToken(token);
        userService.delete(userId);
    }

    @Override
    public UserDto findByToken(String token) {
        String userId = securityService.findUserIdByToken(token);
        User user = userService.findById(userId);
        return new UserDto(user);
    }

    @Override
    public List<UserDto> findAllByToken(String token) {
        List<User> users = userService.findAll();
        return users
                .stream()
                .map(UserDto::new)
                .collect(Collectors.toList());
    }
}
