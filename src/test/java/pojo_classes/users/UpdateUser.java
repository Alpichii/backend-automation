package pojo_classes.users;

public class UpdateUser {

    /**
     * {
     *     "name": "Mr. Leroy Schowalter",
     *     "email": "Myrtle.Goyette17@yahoo.com",
     *     "status": "active"
     * }
     */

    private String name;
    private String email;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
