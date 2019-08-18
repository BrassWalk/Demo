package demo.valueobject;

public class Course {
    private Long id;
    private String username;
    private String description;

    public Course(Long id, String username, String description) {
        this.id = id;
        this.username = username;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }
}
