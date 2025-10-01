package fit.iuh.thang.annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class User {
    private int id;
    private String name;
    private String password;
    @Autowired
    private Group group;

    @Autowired
    public User(Group group) {
        super();
        this.group = group;
    }

    public User(int id, String name, String password, Group group) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.group = group;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Group getGroup() {
        return group;
    }

    @Autowired
    public void setGroup(Group group) {
        this.group = group;
    }
}
