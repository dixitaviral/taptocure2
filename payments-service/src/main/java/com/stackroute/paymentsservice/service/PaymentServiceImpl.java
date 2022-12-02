package com.stackroute.paymentsservice.service;
import com.stackroute.paymentsservice.entity.PaymentDetailsPOJO;
import com.stackroute.paymentsservice.repositry.PaymentRepositry;
import java.util.Map;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@Service
public class PaymentServiceImpl implements PaymentService  {

   @Autowired
    private PaymentRepositry paymentrepo;
    
	@Autowired
	private Environment env;

 

//Method for Creating the Order for Payment.
	@Override
	public Order creatPaymen(int amount, String receiptid) {
	 Order order=null;
	    try {
	      

	        RazorpayClient razorpay = new RazorpayClient(env.getProperty("rzp_key_id"), env.getProperty("rzp_key_secret"));
	        JSONObject orderRequest = new JSONObject();

	        orderRequest.put("amount", amount*100); // amount in the smallest currency
	        orderRequest.put("currency", env.getProperty("rzp_currency"));
	        orderRequest.put("receipt", receiptid);

	         order = razorpay.orders.create(orderRequest);

	       
	    } catch (RazorpayException e) {

	        System.out.println(e.getMessage());
	    }
	  
		return order;
	}
	
	
	
	
//Method for saving the Payment details in Database.
	   @Override
	    public String SavePaymentDetails(Order order) {
	    	PaymentDetailsPOJO   p= new PaymentDetailsPOJO();
	        p.setRazorOrderId(order.get("id"));
	        p.setAmount(order.get("amount"));
	        p.setCurrency(order.get("currency"));
	        p.setReceiptNumber(order.get("receipt"));
	        p.setStatus(order.get("status"));
	        p.setPatientId(1);
	        p.setPatientName("Need to Enter Patient name");
	        p.setPatientEmail("Enter Patient Email");
	        paymentrepo.save(p);
	        return  "Payment is generated and save in database as well on Razor Server with amount INR"+p.getAmount()/100;
	    }


	   
	   
//Method for updating payment status in database post payment completed 	   
		@Override
		public void updateSucessPayment(Map<String, String> data) {
			 
				
	 PaymentDetailsPOJO findByRazorOrderId =paymentrepo.findByRazorOrderId(data.get("RazorOrderId"));
		findByRazorOrderId.setStatus(data.get("status"));
		paymentrepo.save(findByRazorOrderId);
		  
			        
				
		}
		
	
			
		

}
