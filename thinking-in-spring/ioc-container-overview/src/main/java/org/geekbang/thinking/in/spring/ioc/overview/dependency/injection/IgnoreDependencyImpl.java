package org.geekbang.thinking.in.spring.ioc.overview.dependency.injection;


import org.geekbang.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.stereotype.Service;

public class IgnoreDependencyImpl implements IgnoreDependencyService{
    private User user;

    private String name ="yangqiang";

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "IgnoreDependencyImpl{" +
                "user=" + user +
                '}';
    }
}
