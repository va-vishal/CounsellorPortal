package in.vishal.utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import in.vishal.entity.Counsellor;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailUtils {

    @Autowired
    private JavaMailSender mailSender;

    public boolean sendEmail(String subjec,String body,String to) {
    	boolean isSent=false;
    	
    	try {
    		MimeMessage mimeMsge = mailSender.createMimeMessage();
    		MimeMessageHelper helper=new MimeMessageHelper(mimeMsge);
    		helper.setTo(to);
    		helper.setSubject(subjec);
    		helper.setText(body, true);
    		mailSender.send(mimeMsge);
    		isSent=true;
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	return isSent;
    }
}
