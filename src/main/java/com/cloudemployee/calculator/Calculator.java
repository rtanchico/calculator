package com.cloudemployee.calculator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author rtanchico
 */

public class Calculator {

    public static Logger logger = LoggerFactory.getLogger(Calculator.class);
    public static Character[] OPERATORS = {'/', '*', '+', '-'};

    public static final String REGEXNUMBERS = "(\\d+)";
    public static final String REGEXOPERATORS = "[/+,-,/*,//,-]";

    public static ArrayList<Character> operators = new ArrayList<Character>();
    public static ArrayList<Double> numbers = new ArrayList<Double>();

    public void getNumbers(String math) {
        logger.info("List of Numbers");

        Pattern pattern = Pattern.compile(REGEXNUMBERS);
        Matcher matcher = pattern.matcher(math);
        int counter = 0;
        while (matcher.find()) {

            counter++;
            double number = Double.parseDouble(math.substring(matcher.start(), matcher.end()));
            numbers.add(number);
            logger.info(counter + " : " + number);
        }
    }

    public void getOperators(String math) {
        logger.info("List of Operators");
        Pattern pattern = Pattern.compile(REGEXOPERATORS);
        Matcher matcher = pattern.matcher(math);
        while (matcher.find()) {
            operators.add(math.charAt(matcher.start()));

        }
        logger.info(String.valueOf(operators));

    }

    protected void getNextOperator(ArrayList<Character> operators) {
        for (Character operator : OPERATORS) {

            //Division
            A:
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) == '/') {
                    operators.remove(i);
                    numbers.set(i, (numbers.get(i) / numbers.get(i + 1)));
                    numbers.remove(i + 1);
                    continue A;
                }
            }

            //Multiplication
            B:
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) == '*') {
                    operators.remove(i);
                    numbers.set(i, (numbers.get(i) * numbers.get(i + 1)));
                    numbers.remove(i + 1);
                    continue B;
                }
            }

            //Addition
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) == '+') {
                    operators.remove(i);
                    numbers.set(i, (numbers.get(i) + numbers.get(i + 1)));
                    numbers.remove(i + 1);
                    continue;
                }
            }

            //Subtraction
            for (int i = 0; i < operators.size(); i++) {

                if (operators.get(i) == '-') {
                    operators.remove(i);
                    numbers.set(i, (numbers.get(i) - numbers.get(i + 1)));
                    numbers.remove(i + 1);
                    continue;
                }
            }
        }
    }
}