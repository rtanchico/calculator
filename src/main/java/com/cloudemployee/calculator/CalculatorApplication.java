package com.cloudemployee.calculator;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Iterator;
import java.util.Scanner;

import static com.cloudemployee.calculator.Calculator.*;

/**
 * @author rtanchico
 */

@SpringBootApplication
public class CalculatorApplication {

    public static void main(String[] args) {

        SpringApplication.run(CalculatorApplication.class, args);

    }

    @Bean
    public Calculator calculator() {
        return new Calculator();
    }

    @Bean
    public ApplicationRunner applicationRunner(Calculator calculator) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an operation (ex. (81*52)-(29*36)): ");
        String inputString = scanner.next();

        calculator.getNumbers(inputString);
        calculator.getOperators(inputString);
        calculator.getNextOperator(operators);

        Iterator<Double> i = numbers.iterator();

        while (i.hasNext()) {
            logger.info("Answer : " + String.valueOf(i.next()) + ' ');
        }
        return null;
    }

}