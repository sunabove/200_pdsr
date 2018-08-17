package web.model;

import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter; 

@Entity
@Table(name = "user_tbl")

public class User extends CommonEntity { 
	
	private static final long serialVersionUID = -6023492649132057963L;

	@Id
	@Getter @Setter public String userId ;  
	
	@Getter @Setter public String passwd;	
	@Getter @Setter public String email;	
	
	//@Getter @Setter public String roleCode = "USER-ROLE-NORMAL" ;
	
	@OneToOne
	@JoinColumn(name = "roleCode")
	@Getter @Setter public Code roleCode;
	
	@Getter @Setter public String name;
	
	@Getter @Setter public Timestamp lastLoginDt ;
	@Getter @Setter public Timestamp lastLogOutDt ;
	
	public User() {
	}

	public User(String userId, String passwd) {
		this.userId = userId; 
		this.passwd = passwd ;
	}  
	
}