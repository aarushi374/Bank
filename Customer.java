
public class Customer {
private String to,from;
private int amt;
public Customer()
{
	super();
}
public Customer(String to, String from,int amt)
{
	this.to=to;
	this.from=from;
	this.amt=amt;
}

public String getTo()
{
	return to;
}
public void setTo(String to)
{
	this.to=to;
}
public String getFrom()
{
	return from;
}
public void setFrom(String from)
{
	this.from=from;
}
public int getAmt()
{
	return amt;
}
public void setAmount(int amt)
{
	this.amt=amt;
}
}
