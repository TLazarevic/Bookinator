package events;

import java.io.Serializable;
import java.util.Date;

import org.kie.api.definition.type.Expires;
import org.kie.api.definition.type.Role;
import org.kie.api.definition.type.Timestamp;

@Role(Role.Type.EVENT)
@Timestamp("executionTime")
@Expires("10m")
public class BookLoanMade implements Serializable {

    private static final long serialVersionUID = 1L;
    private Date executionTime;
    private Long userId;
    private Long bookLoanId;
    
	
	public BookLoanMade(Long userId, Long bookLoanId) {
		super();
		this.executionTime = new Date();
		this.userId = userId;
		this.bookLoanId = bookLoanId;
	}
	public BookLoanMade() {
		super();
	}
	public Date getExecutionTime() {
		return executionTime;
	}
	public void setExecutionTime(Date executionTime) {
		this.executionTime = executionTime;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getBookLoanId() {
		return bookLoanId;
	}
	public void setBookLoanId(Long bookLoanId) {
		this.bookLoanId = bookLoanId;
	}

    
}
