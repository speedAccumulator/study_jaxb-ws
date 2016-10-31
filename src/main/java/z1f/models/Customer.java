package z1f.models;

public class Customer {
	protected int custId;	
	protected String custName;	
	
	
	public void setCustName(String custName) {
        this.custName = custName;
    }
	public String getCustName() {
        return custName;
    }
    
   	public void setCustId(int custId) {
        this.custId = custId;
    }
	public int getCustId() {
        return custId;
    }
	
}