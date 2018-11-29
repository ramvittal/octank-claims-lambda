package org.octank.claims.main;



import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.octank.claims.model.Claim;
import org.octank.claims.model.ClaimProcessing;
import org.octank.claims.model.ClaimProcessingId;

/**
 * @author rvvittal
 */
public class ClaimsProcessingHandler implements RequestHandler<Request, String> {

    @Override
    public String handleRequest(Request request, Context context) {
    	
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        StringBuilder claimsSb = new StringBuilder();
        
        try (Session session = sessionFactory.openSession()) {
        	
            session.beginTransaction();
            
            //1. get list of submitted claims

			CriteriaBuilder builder = session.getCriteriaBuilder();
	         CriteriaQuery<Claim> query = builder.createQuery(Claim.class);
	         Root<Claim> root = query.from(Claim.class);
	         query.select(root).where(builder.equal(root.get("claimStatus"), request.getClaimStatus()));
	         
	         Query<Claim> qc = session.createQuery(query);
	         List<Claim> claims=qc.getResultList();
	         for (Claim claim : claims) {
	            System.out.println(claim.getClaimId());
	         }
            
	         
	         //2. for each submitted claim, perform edits, create ClaimProcessing record, update oracle claim status, and send log record to elastic search
	         
	         for (Claim claim : claims) {
		           ClaimProcessing cp = new ClaimProcessing();
		           ClaimProcessingId cpi = new ClaimProcessingId();
		           
		           cpi.setClaimId(claim.getClaimId());
		           cpi.setClaimProcessDate(new Date());
		           
		           cp.setId(cpi);
		           cp.setClaimStatus("Denied");
		           String claimIdSt = claim.getClaimId() +"~" + claim.getClaimStatus();
		           
		           session.save(cp);
		           claimsSb = claimsSb.length() > 0 ? claimsSb.append("," + claimIdSt) : claimsSb.append(claimIdSt);
		           System.out.println("**** Processed claims: " +claimsSb.toString() + "***End");
		           
		      }
	         
	         
	         
            session.getTransaction().commit();
        }

        return claimsSb.toString();
    }
}

