package com.learning;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

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
        int result = 0, lastEat = 0;
        Set<Integer> processCheese = new HashSet<>();
        for (int cheeseBlock : userInput.getInputCheeseBlocks()) {
            if (!processCheese.contains(cheeseBlock)) {
                if (lastEat < cheeseBlock) {
                    lastEat = cheeseBlock - lastEat;
                } else {
                    lastEat = cheeseBlock;
                }
                result += lastEat;
            }
            processCheese.add(cheeseBlock);
        }
        System.out.println(result);
    }
}
