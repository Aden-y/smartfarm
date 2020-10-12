
package beans;
/**
 *
 * @author vworldstudios
 */

public class User  {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String type;
    private String registeredon;
    private String lasstloged;
    private Integer phone;

    public User(Long id, String firstname, String lastname,
                String email, String password, String type,
                String registeredon, String lasstloged, Integer phone) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.type = type;
        this.registeredon = registeredon;
        this.lasstloged = lasstloged;
        this.phone = phone;
    }

    public String getFirstname() {
        return firstname;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
    public String getType() {
        return type;
    }
    public String getRegisteredon() {
        return registeredon;
    }

    public String getLasstloged() {
        return lasstloged;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setRegisteredon(String registeredon) {
        this.registeredon = registeredon;
    }

    public void setLasstloged(String lasstloged) {
        this.lasstloged = lasstloged;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    
    
}
