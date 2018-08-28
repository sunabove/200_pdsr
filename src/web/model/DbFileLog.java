package web.model;

import java.io.File;
import java.sql.Timestamp;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "db_file_log_tbl" )

public class DbFileLog extends EntityCommon {  

	private static final long serialVersionUID = 4024002681670288781L;

	@Id
	@Column(length=191)
	@Getter @Setter public String fileLogId ;

	@OneToOne 
	@Getter @Setter public User downloadUser ;  
	
	@OneToOne 
	@Getter @Setter public DbFile downloadFile ;  
	
	@Column(length=191)
	@Getter @Setter public String gubun ;  
	
	@Column(length=191)
	@Getter @Setter public String filePath ;  
	
	@Getter @Setter public Integer fizeSize ;  
	
	@Getter @Setter public Integer downloadCount = 0 ;  
	
	@Getter @Setter public Boolean dowloadResult ;  
	
	@Column(length=191)
	@Getter @Setter public String ipAddr ;  
	
	public DbFileLog() {
	}  
	
	public String getHourIntervalDesc() {
		String fileLogId = this.fileLogId ;
		if( null == fileLogId ) {
			return null; 
		}
		
		String [] data = fileLogId.replaceAll( "TOT-DOWN-NO-", "" ).split( " " ); 
		
		if( null == data ) {
			return null ;  
		} if( 1 == data.length ) {
			return data[ 0 ] ; 
		}
		
		String desc = data[ data.length - 1 ] ;
		
		int hour = this.parseInt( desc , 0 );
		
		desc = desc + ":00" + " ~ " + ( 10 > hour ? "0" : "" ) + ( hour + 1 ) + ":00";
		
		return desc ; 
	}

}