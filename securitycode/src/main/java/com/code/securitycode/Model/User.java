
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table(name = "user")
	public class User {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;

	    private String username;
	    private String password;

	    public User() {
	    }

	    public User(String username, String password) {
	        this.username = username;
	        this.password = password;
	    }

	    
	}

}
