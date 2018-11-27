package org.octank.claims.main;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.octank.claims.model.Claim;
import org.octank.claims.model.ClaimProcessing;
import org.octank.claims.model.ClaimProcessingId;
import org.octank.claims.model.Staff;

import com.amazonaws.services.lambda.runtime.Context;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import javax.persistence.criteria.*;


public class ClaimsProcessingTestDriver {

	public static void main(String[] args) {
		
		Request request = new Request();
		request.setRequestId("101");
		request.setClaimStatus("Submitted");
		
		handleRequest(request);
		

	}
	
	
	 public static String handleRequest(Request request) {
	       
		 SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		 Session sessionObj = null;
		 String status="success";
		 
		 /*
	        
	        try (Session session = sessionFactory.openSession()) {
	        
	        	session.beginTransaction();
	            Staff s = new Staff();
	            s.setStaffId("STAFF-100");
	            session.save(s);
	            session.getTransaction().commit();
	        }

	        return String.format("Process request %s %s.", request.requestId, request.claimStatus);
	       */
		 
		 
		 try {
				sessionObj = sessionFactory.openSession();
				sessionObj.beginTransaction();

				
				
				
				CriteriaBuilder builder = sessionObj.getCriteriaBuilder();
		         CriteriaQuery<Claim> query = builder.createQuery(Claim.class);
		         Root<Claim> root = query.from(Claim.class);
		         query.select(root).where(builder.equal(root.get("claimStatus"), request.getClaimStatus()));
		         
		         Query<Claim> qc = sessionObj.createQuery(query);
		         List<Claim> claims=qc.getResultList();
		         for (Claim claim : claims) {
		            System.out.println(claim.getClaimId());
		         }

				// Committing The Transactions To The Database
				sessionObj.getTransaction().commit();
				
				
		 
				
				
			} catch(Exception sqlException) {
				if(null != sessionObj.getTransaction()) {
					System.out.println("\n.......Transaction Is Being Rolled Back.......");
					sessionObj.getTransaction().rollback();
					status="failure";
				}
				sqlException.printStackTrace();
			} finally {
				if(sessionObj != null) {
					sessionObj.close();
				}
				
				
			}
		 
		 return status;

	        
	    }

}
