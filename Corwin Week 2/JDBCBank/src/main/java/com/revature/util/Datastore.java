package com.revature.util;

import java.sql.SQLException;
import java.util.ArrayList;

import com.revature.beans.Account;
import com.revature.beans.Application;
import com.revature.beans.Customer;
import com.revature.beans.CustomerAccountRelation;
import com.revature.beans.CustomerApplicationRelation;
import com.revature.beans.Employee;
import com.revature.beans.Transaction;
import com.revature.daoimpl.AccountDAOImpl;
import com.revature.daoimpl.ApplicationDAOImpl;
import com.revature.daoimpl.CustomerAccountRelationDAOImpl;
import com.revature.daoimpl.CustomerApplicationRelationDAOImpl;
import com.revature.daoimpl.CustomerDAOImpl;
import com.revature.daoimpl.EmployeeDAOImpl;
import com.revature.daoimpl.TransactionDAOImpl;

public class Datastore {
	
	private static Datastore instance = null;
	
	private CustomerDAOImpl customerImpl;
	private ApplicationDAOImpl applicationImpl;
	private AccountDAOImpl accountImpl;
	private EmployeeDAOImpl employeeImpl;
	private TransactionDAOImpl transactionImpl;
	private CustomerAccountRelationDAOImpl custAccRelImpl;
	private CustomerApplicationRelationDAOImpl custAppRelImpl;
	
	private Datastore() {
		   	this.customerImpl = new CustomerDAOImpl();
		   	this.applicationImpl = new ApplicationDAOImpl();
		   	this.accountImpl = new AccountDAOImpl();
		   	this.employeeImpl = new EmployeeDAOImpl();
		   	this.transactionImpl = new TransactionDAOImpl();
		   	this.custAccRelImpl = new CustomerAccountRelationDAOImpl();
		   	this.custAppRelImpl = new CustomerApplicationRelationDAOImpl();
	}
	
    public static Datastore getInstance()
    {
        if (instance == null)
            instance = new Datastore();

        return instance;
    }
    
    public void addCustomer(Customer c) {
    	try {
			this.customerImpl.createCustomer(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateCustomer(Customer c) {
    	try {
			this.customerImpl.updateCustomer(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteCustomer(Customer c) {
    	try {
			this.customerImpl.deleteCustomer(c);
			if(c.getApplications() != null) {
				for(Application a: c.getApplications()) {
					ArrayList<CustomerApplicationRelation> relapps = new ArrayList<CustomerApplicationRelation>();
					relapps = this.custAppRelImpl.findCustomerApplicationRelationByCustomerId(c.getID());
					for(CustomerApplicationRelation car: relapps) {
						Application application = this.applicationImpl.findApplication(car.getApplication_id());
						application.removeCustomer(c);
						this.applicationImpl.updateApplication(application);
						if(application.getCustomers().size()==0) {
							this.applicationImpl.deleteApplication(application);
						}
					}
					this.applicationImpl.deleteApplication(a);
				}
			}
			if(c.getAccounts() != null) {
				for(Account a: c.getAccounts()) {
					ArrayList<CustomerAccountRelation> relapps = new ArrayList<CustomerAccountRelation>();
					relapps = this.custAccRelImpl.findCustomerAccountRelationByCustomerId(c.getID());
					for(CustomerAccountRelation car: relapps) {
						Account account = this.accountImpl.findAccount(car.getAccount_id());
						account.removeCustomer(c);
						this.accountImpl.updateAccount(account);
						if(account.getCustomers().size()==0) {
							this.accountImpl.deleteAccount(account);
						}
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Customer getCustomerById(int ID) {
    	Customer c = null;
    	try {
			c = this.customerImpl.findCustomer(ID);
			ArrayList<CustomerApplicationRelation> relapps = new ArrayList<CustomerApplicationRelation>();
			relapps = this.custAppRelImpl.findCustomerApplicationRelationByCustomerId(c.getID());
			for(CustomerApplicationRelation car: relapps) {
				Application a = this.getApplicationById(car.getApplication_id());
				a.addCustomer(c);
				c.addApplication(a);
			}
			
			ArrayList<CustomerAccountRelation> relaccs = new ArrayList<CustomerAccountRelation>();
			relaccs = this.custAccRelImpl.findCustomerAccountRelationByCustomerId(c.getID());
			for(CustomerAccountRelation car: relaccs) {
				Account a = this.getAccountById(car.getAccount_id());
				a.addCustomer(c);
				c.addAccount(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (NullPointerException e) {
			//e.printStackTrace();
		}
    	return c;
    }
    public Customer getCustomerByUsername(String username) {
    	Customer c = null;
    	try {
			c = this.customerImpl.findCustomerByUsername(username);
			ArrayList<CustomerApplicationRelation> relapps = new ArrayList<CustomerApplicationRelation>();
			relapps = this.custAppRelImpl.findCustomerApplicationRelationByCustomerId(c.getID());
			for(CustomerApplicationRelation car: relapps) {
				Application a = this.getApplicationById(car.getApplication_id());
				a.addCustomer(c);
				c.addApplication(a);
			}
			
			ArrayList<CustomerAccountRelation> relaccs = new ArrayList<CustomerAccountRelation>();
			relaccs = this.custAccRelImpl.findCustomerAccountRelationByCustomerId(c.getID());
			for(CustomerAccountRelation car: relaccs) {
				Account a = this.getAccountById(car.getAccount_id());
				a.addCustomer(c);
				c.addAccount(a);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (NullPointerException e) {
			//e.printStackTrace();
		}
    	return c;
    }
    public ArrayList<Customer> getCustomers(){
    	ArrayList<Customer> c = null;
    	try {
			c = this.customerImpl.findAllCustomers();
			for(Customer customer:c) {
				ArrayList<CustomerApplicationRelation> relapps = new ArrayList<CustomerApplicationRelation>();
				relapps = this.custAppRelImpl.findCustomerApplicationRelationByCustomerId(customer.getID());
				if(!relapps.isEmpty()) {
					for(CustomerApplicationRelation car: relapps) {
						Application a = this.getApplicationById(car.getApplication_id());
						a.addCustomer(customer);
						customer.addApplication(a);
					}
				}
				ArrayList<CustomerAccountRelation> relaccs = new ArrayList<CustomerAccountRelation>();
				relaccs = this.custAccRelImpl.findCustomerAccountRelationByCustomerId(customer.getID());
				if(!relaccs.isEmpty()) {
					for(CustomerAccountRelation car: relaccs) {
						Account a = this.getAccountById(car.getAccount_id());
						a.addCustomer(customer);
						customer.addAccount(a);
					}
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
    	return c;
    }
    
    public void addEmployee(Employee c) {
    	try {
			this.employeeImpl.createEmployee(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateEmployee(Employee c) {
    	try {
			this.employeeImpl.updateEmployee(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteEmployee(Employee c) {
    	try {
			this.employeeImpl.deleteEmployee(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Employee getEmployeeById(int ID) {
    	Employee c = null;
    	try {
			c = this.employeeImpl.findEmployee(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public Employee getEmployeeByUsername(String username) {
    	Employee c = null;
    	try {
			c = this.employeeImpl.findEmployeeByUsername(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public ArrayList<Employee> getEmployees(){
    	ArrayList<Employee> c = null;
    	try {
			c = this.employeeImpl.findAllEmployees();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    
    public void addAccount(Account c) {
    	try {
			this.accountImpl.createAccount(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateAccount(Account c) {
    	try {
			this.accountImpl.updateAccount(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteAccount(Account c) {
    	try {
			this.accountImpl.deleteAccount(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public Account getAccountById(int ID) {
    	Account c = null;
    	try {
			c = this.accountImpl.findAccount(ID);
			/*ArrayList<CustomerAccountRelation> rels= this.custAccRelImpl.findAllCustomerAccountRelations();
			for(CustomerAccountRelation rel:rels) {
				if(rel.getAccount_id() == c.getID()) {
					c.addCustomer(this.getCustomerById(rel.getCustomer_id()));
				}
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    
    public Account getAccountByFingerprint(int fingerprint) {
    	Account c = null;
    	try {
			c = this.accountImpl.findAccountByFingerprint(fingerprint);
			/*ArrayList<CustomerAccountRelation> rels= this.custAccRelImpl.findAllCustomerAccountRelations();
			for(CustomerAccountRelation rel:rels) {
				if(rel.getAccount_id() == c.getID()) {
					c.addCustomer(this.getCustomerById(rel.getCustomer_id()));
				}
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public ArrayList<Account> getAccounts(){
    	ArrayList<Account> c = null;
    	try {
			c = this.accountImpl.findAllAccounts();
			/*for(Account acc:c) {
				ArrayList<CustomerAccountRelation> rels= this.custAccRelImpl.findAllCustomerAccountRelations();
				for(CustomerAccountRelation rel:rels) {
						if(rel.getAccount_id() == acc.getID()) {
							acc.addCustomer(this.getCustomerById(rel.getCustomer_id()));
						}
				}
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    
    public void addCustomerToAccount(Customer c,Account a) {
    	try {
    		this.custAccRelImpl.createCustomerAccountRelation(new CustomerAccountRelation(c.getID(),a.getID()));
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void addCustomerToApplication(Customer c,Application a) {
    	try {
    		this.custAppRelImpl.createCustomerApplicationRelation(new CustomerApplicationRelation(c.getID(),a.getID()));
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    
    public void addApplication(Application c) {
    	try {
			this.applicationImpl.createApplication(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateApplication(Application c) {
    	try {
			this.applicationImpl.updateApplication(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteApplication(Application c) {
    	try {
			this.applicationImpl.deleteApplication(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void applicationLoadCustomers(Application a) {
    	try {
			ArrayList<CustomerApplicationRelation> rels= this.custAppRelImpl.findAllCustomerApplicationRelations();
			for(CustomerApplicationRelation rel:rels) {
				if(rel.getApplication_id() == a.getID()) {
					a.addCustomer(this.getCustomerById(rel.getCustomer_id()));
				}
			}
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public void accountLoadCustomers(Account a) {
    	try {
    		ArrayList<Customer> customers = new ArrayList<Customer>();
			ArrayList<CustomerAccountRelation> rels= this.custAccRelImpl.findAllCustomerAccountRelations();
			for(CustomerAccountRelation rel:rels) {
				if(rel.getAccount_id() == a.getID()) {
					customers.add(this.getCustomerById(rel.getCustomer_id()));
				}
			}
			a.setCustomers(customers);
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
    }
    public Application getApplicationById(int ID) {
    	Application c = null;
    	try {
			c = this.applicationImpl.findApplication(ID);
			/*ArrayList<CustomerApplicationRelation> rels= this.custAppRelImpl.findAllCustomerApplicationRelations();
			for(CustomerApplicationRelation rel:rels) {
				if(rel.getApplication_id() == c.getID()) {
					c.addCustomer(this.getCustomerById(rel.getCustomer_id()));
				}
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public Application getApplicationByFingerprint(int fingerprint) {
    	Application c = null;
    	try {
			c = this.applicationImpl.findApplicationByFingerprint(fingerprint);
			/*ArrayList<CustomerApplicationRelation> rels= this.custAppRelImpl.findAllCustomerApplicationRelations();
			for(CustomerApplicationRelation rel:rels) {
				if(rel.getApplication_id() == c.getID()) {
					c.addCustomer(this.getCustomerById(rel.getCustomer_id()));
				}
			}*/
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public ArrayList<Application> getApplications(){
    	ArrayList<Application> c = null;
    	try {
			c = this.applicationImpl.findAllApplications();
			/*for(Application app:c) {
				ArrayList<CustomerApplicationRelation> rels= this.custAppRelImpl.findAllCustomerApplicationRelations();
				for(CustomerApplicationRelation rel:rels) {
						if(rel.getApplication_id() == app.getID()) {
							app.addCustomer(this.getCustomerById(rel.getCustomer_id()));
						}
				}
			}*/
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    
    public void addTransaction(Transaction c) {
    	try {
			this.transactionImpl.createTransaction(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void updateTransaction(Transaction c) {
    	try {
			this.transactionImpl.updateTransaction(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void deleteTransaction(Transaction c) {
    	try {
			this.transactionImpl.deleteTransaction(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public void accountLoadTransaction(Account acc) {
    	ArrayList<Transaction> transactions = new ArrayList<Transaction>();
		ArrayList<Transaction >tr = this.getTransactions();
		for(Transaction trans: tr) {
			if(trans.getFrom_account_id() == acc.getID()) {
				transactions.add(trans);
			}
		}
		acc.setTransactions(transactions);
    }
    public Transaction getTransactionById(int ID) {
    	Transaction c = null;
    	try {
			c = this.transactionImpl.findTransaction(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }
    public ArrayList<Transaction> getTransactions(){
    	ArrayList<Transaction> c = null;
    	try {
			c = this.transactionImpl.findAllTransactions();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return c;
    }

}
