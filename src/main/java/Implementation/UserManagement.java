package Implementation;

import Model.Enum.TierType;
import Model.User;
import java.util.HashMap;

public class UserManagement {
    private static volatile UserManagement instance;

    private final HashMap<String, User> users;

    private UserManagement() {
        users = new HashMap<>();
    }

    public static UserManagement getInstance() {
        if (instance == null) {
            synchronized (UserManagement.class) {
                if (instance == null)
                    instance = new UserManagement();
            }
        }
        return instance;
    }

    public boolean registerUser(String username, String password, TierType tier) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Registration failed.");
            return false;
        }
        try {
            User user = UserFactory.createUser(username, password, tier);
            users.put(username, user);
            System.out.println("User registered successfully: " + username);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        } catch (Exception e) {
            System.out.println("Registration failed: " + e.getMessage());
            return false;
        }
    }

    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("Login successful: " + username);
            return user;
        } else {
            System.out.println("Login failed: Invalid username or password.");
            return null;
        }
    }

    public User getUser(String username) {
        return users.get(username);
    }
}

