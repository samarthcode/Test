package com.learning;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class UserInput {
    private int[] inputCheeseBlocks;

    public UserInput(int[] inputCheeseBlocks) {
        this.inputCheeseBlocks = inputCheeseBlocks;
    }

    public int[] getInputCheeseBlocks() {
        return this.inputCheeseBlocks;
    }
}

public class CheeseBlockWeight {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        if (testCases < 1 || testCases > 200) {
            throw new Exception("Please enter test case input between 1 and 200");
        }
        List<UserInput> userInputList = new ArrayList<>();
        for (int i = 0; i < testCases; i++) {
            userInputList.add(userInput(scanner));
        }
        for (int i = 0; i < testCases; i++) {
            processResult(userInputList.get(i));
        }
    }

    private static UserInput userInput(Scanner scanner) throws Exception {
        int cheeseInputCount = scanner.nextInt();
        if (cheeseInputCount < 1 || cheeseInputCount > 1000) {
            throw new Exception("Please enter expected input between 1 and 100");
        }
        int[] inputCheeseBlocks = new int[cheeseInputCount];
        for (int j = 0; j < cheeseInputCount; j++) {
            inputCheeseBlocks[j] = scanner.nextInt();
        }
        return new UserInput(inputCheeseBlocks);
    }

    private static void processResult(UserInput userInput) {
        int[] inputCheeseBlocks = userInput.getInputCheeseBlocks();
        int finalResult = 0;
        int tempResult;
        if (inputCheeseBlocks.length > 1) {
            for (int i = 0; i < 2; i++) {
                tempResult = inputCheeseBlocks[i];
                for (int j = i + 2; j < inputCheeseBlocks.length; j++) {
                    tempResult += inputCheeseBlocks[j];
                    int tempMax = 0;
                    for (int k = j + 2; k < inputCheeseBlocks.length; k++) {
                        int value = tempResult + inputCheeseBlocks[k];
                        tempMax = Math.max(value, tempMax);
                    }
                    tempResult = Math.max(tempMax, tempResult);
                    finalResult = Math.max(tempResult, finalResult);
                    tempResult = inputCheeseBlocks[i];
                }
            }
        } else if (inputCheeseBlocks.length == 1) {
            finalResult = inputCheeseBlocks[0];
        }
        System.out.println(finalResult);
    }
}
