package trip.advisor.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class OpenApiConfig {

	@Value("${openapi.dev-url}")
	private String devUrl;

	@Bean
	public OpenAPI myOpenAPI() {
		Server devServer = new Server();
		devServer.setUrl(devUrl);
		devServer.setDescription("Server URL in DevelopmenT environment");

		Contact contact = new Contact();
		contact.setEmail("viliusm@outlook.com");
		contact.setName("Mindaugas");
		contact.setUrl("https://github.com/SunMind/TripAdvisor/tree/master");

		Info info = new Info().title("Trip Advisor API").version("1.0").contact(contact).description(
				"This API exposes endpoints to manage items for trip and best possible backpack recommendation.");

		return new OpenAPI().info(info).servers(List.of(devServer));
	}
}
