package email;

import io.javalin.Javalin;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

import static j2html.TagCreator.*;

public class Main {

    public static void main(String[] args) {

        Javalin app = Javalin.create()
                .port(7002)
                .start();

        app.get("/", ctx -> ctx.html(
                form().withAction("/contact-us").withMethod("post").with(
                        input().withName("subject").withPlaceholder("Subject"),
                        br(),
                        textarea().withName("message").withPlaceholder("Your message ..."),
                        br(),
                        button("Submit")
                ).render()
        ));

        app.post("/contact-us", ctx -> {
            Email email = new SimpleEmail();
            email.setHostName("smtp.googlemail.com");
            email.setSmtpPort(465);
            email.setAuthenticator(new DefaultAuthenticator("toztemel@gmail.com", "!!82SNTHgg"));
            email.setSSLOnConnect(true);
            email.setFrom("toztemel@gmail.com");
            email.setSubject(ctx.formParam("subject")); // subject from HTML-form
            email.setMsg(ctx.formParam("message")); // message from HTML-form
            email.addTo("toztemel@yahoo.com");
            email.send(); // will throw email-exception if something is wrong
            ctx.redirect("/contact-us/success");
        });

        app.get("/contact-us/success", ctx -> ctx.html("Your message was sent"));

    }

}