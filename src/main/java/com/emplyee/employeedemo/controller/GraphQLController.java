package com.emplyee.employeedemo.controller;

import com.emplyee.employeedemo.service.GraphQLService;
import graphql.ExecutionResult;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class GraphQLController {

  @Autowired
  GraphQLService graphQLService;

  @RequestMapping(value = "/stockData")
  public String getPreAuthDecisionData(@RequestBody String query) {
    ExecutionResult execute = graphQLService.initiateGraphQL().execute(query);
    Map<String, String> obj = (Map<String, String>) execute.getData();
    JSONObject jsonObject = new JSONObject(obj);
    return jsonObject.toString();
  }

}
