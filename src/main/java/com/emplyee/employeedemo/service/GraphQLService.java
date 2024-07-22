package com.emplyee.employeedemo.service;

import com.emplyee.employeedemo.repository.StockDataFetcher;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

@Service
public class GraphQLService {
  private GraphQL graphQL;

  @Autowired
  StockDataFetcher stockFetcher;

  @Value("schema.graphql")
  private ClassPathResource classPathLoader;

  @PostConstruct
  private void loadSchema() throws IOException {
    InputStream st = classPathLoader.getInputStream();
    Reader targetReader = new InputStreamReader(st);

    TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(targetReader);
    RuntimeWiring runtimeWiring = buildRuntimeWiring();

    GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    graphQL = GraphQL.newGraphQL(graphQLSchema).build();
  }

  private RuntimeWiring buildRuntimeWiring() {
    return RuntimeWiring.newRuntimeWiring()
        .type("Query", typeWiring -> typeWiring.dataFetcher("stocks", stockFetcher))
        .build();
  }

  public GraphQL initiateGraphQL() {
    return graphQL;
  }
}
