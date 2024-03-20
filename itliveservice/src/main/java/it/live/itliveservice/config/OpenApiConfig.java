package it.live.itliveservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;


@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Abdulaziz",
                        email = "omonov2006omonov@gmail.com",
                        url = "#!"
                ),
                description = "It live service xizmati uchun",
                title = "IT LIVE",
                version = "1.0",
                license = @License(
                        name = "No License",
                        url = "No License"
                ),
                termsOfService = "Terms of service"
        ),
        security = {
                @SecurityRequirement(
                        name = "Bearer Auth"
                )
        }

)
@SecurityScheme(
        name = "Bearer Auth",
        description = "JWT auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}