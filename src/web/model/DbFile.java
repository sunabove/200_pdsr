package web.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "db_file_tbl"
 , indexes = { @Index(name = "file_no_idx", columnList = "file_no") }
)

public class DbFile extends EntityCommon { 
	private static final long serialVersionUID = -8745797345335307150L;

	@Id
	@Column( length = 191 )
	@Getter @Setter public String fileId ;

	@Getter @Setter public String gubunCode ;
	
	@Column( name="file_no" )
	@Getter @Setter public String fileNo ;

	@Column(length=255)
	@Getter @Setter public String fileName ;
	
	@Column(length=1000)
	@Getter @Setter public String filePath ;
	
	@Getter @Setter public Timestamp fileModDt ;

	@Lob
	//@Column( length = 1_000_000_000 )
	@Getter
	@Setter
	public byte [] content;

	public DbFile() {
	} 
	
	public boolean isFileExist() {
		String filePath = this.filePath ;
		
		if( isEmpty( filePath ) ) {
			return false ; 
		}
		
		var valid = false ; 
		
		File file = new File( filePath );
		
		valid = file.exists();
		
		return valid; 
	}

}