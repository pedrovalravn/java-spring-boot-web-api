package personal.myfirstwebapi.repository;

import org.springframework.stereotype.Repository;
import personal.myfirstwebapi.model.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    public void save(User user) {
        System.out.println("SAVE - Receiving the user in the repository layer");
        System.out.println(user);
    }

    public void update(User user) {
        System.out.println("UPDATE - Receiving the user in the repository layer");
        System.out.println(user);
    }

    public void remove(Integer id) {
        System.out.println(String.format("DELETE/id - Receiving the id: %d to delete a user", id));
        System.out.println(id);
    }

    public List<User> listAll() {
        System.out.println("LIST - Listing system users");
        List<User> users = new ArrayList<>();
        users.add(new User("peter", "qwerty123"));
        users.add(new User("walter", "ytrewq321"));
        return users;
    }

    public User findById(Integer id) {
        System.out.println(String.format("FIND/id - Receiving the id: %d to locate a user", id));
        return new User("peter", "qwerty123");
    }

    public List<User> findAll() {
        return null;
    }
}
