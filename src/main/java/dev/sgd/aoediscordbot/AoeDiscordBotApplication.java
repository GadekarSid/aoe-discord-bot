package dev.sgd.aoediscordbot;

import dev.sgd.aoediscordbot.discordutils.MessageEventListener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AoeDiscordBotApplication {
	public static String discordBotToken;

	@Value("${discord.bot.token}")
	public void setHelloWorld(String token) {
		discordBotToken = token;
	}
	public static void main(String[] args) {
		SpringApplication.run(AoeDiscordBotApplication.class, args);
		JDABuilder jdaBuilder = JDABuilder.createDefault(discordBotToken);
		jdaBuilder.enableIntents(GatewayIntent.MESSAGE_CONTENT);
		jdaBuilder.addEventListeners(new MessageEventListener()).build();
	}

}
