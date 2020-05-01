import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.apache.log4j.Logger;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    private static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) throws LoginException {
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);
        String token = System.getProperty("token");
        logger.info("loggeeer");
        jdaBuilder.setToken(token);
        jdaBuilder.addEventListeners(new Main());
        jdaBuilder.build();
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        System.out.println("Received a message from "
                + event.getAuthor().getName()
                + ": " +
                event.getMessage().getContentDisplay());
        if(event.getMessage().getContentRaw().equals("!ping")){
            event.getChannel().sendMessage("RRR").queue();
        }
    }
}
