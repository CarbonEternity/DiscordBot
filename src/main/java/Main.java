import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import javax.security.auth.login.LoginException;

public class Main extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        JDABuilder jdaBuilder = new JDABuilder(AccountType.BOT);
        String token = "";
        jdaBuilder.setToken(token);
        jdaBuilder.build();
    }

    @Override
    public void onMessageReceived(@Nonnull MessageReceivedEvent event) {
        System.out.println("Received a message from "
                + event.getAuthor().getName()
                + ": " +
                event.getMessage().getContentDisplay());
    }
}
