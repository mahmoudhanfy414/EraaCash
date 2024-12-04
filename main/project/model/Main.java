package main.project.model;

import main.project.service.AccountService;
import main.project.service.AccountServiceImpl;
import main.project.service.ApplicationServiceImpl;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        new ApplicationServiceImpl().run();

    }



}
