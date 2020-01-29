package railticket.Util;

import java.io.IOException;
 
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
 
public class MailUtil {
 
    static String apiKey = "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";
 
    public static void main(String[] args) {
 
         Email from = new Email("farooqmohamed21@gmail.com");
            String subject = "Reg: Account Creation";
            Email to = new Email("farooqmohamed21@gmail.com");
            String bodyContent = "Successfully, account is created";
            Content content = new Content("text/plain", bodyContent);
            Mail mail = new Mail(from, subject, to, content);
 
            SendGrid sg = new SendGrid(apiKey);
            Request request = new Request();
            try {
              request.setMethod(Method.POST);
              request.setEndpoint("mail/send");
              request.setBody(mail.build());
              Response response = sg.api(request);
              System.out.println(response.getStatusCode());
              System.out.println(response.getBody());
              System.out.println(response.getHeaders());
            } catch (IOException ex) {
              System.out.println(ex);
            }
          }
 
    }