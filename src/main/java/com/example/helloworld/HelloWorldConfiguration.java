package com.example.helloworld;

import com.example.helloworld.core.Template;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.db.DatabaseConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;

@SuppressWarnings("FieldMayBeFinal")
public class HelloWorldConfiguration extends Configuration {

    @NotEmpty
    private String template;
    @NotEmpty
    private String defaultName = "Stranger";
    @Valid
    @NotNull
    @JsonProperty
    private DatabaseConfiguration database = new DatabaseConfiguration();

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public Template buildTemplate() {
        return new Template(template, defaultName);
    }

    public DatabaseConfiguration getDatabaseConfiguration() {
        return database;
    }
}
