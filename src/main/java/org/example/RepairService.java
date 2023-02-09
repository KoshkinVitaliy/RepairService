package org.example;

import java.util.ArrayList;
import java.util.Scanner;


public class RepairService {
    private int[] price = {500, 3000, 6000, 10000, 500};
    private ArrayList<String> serviceList = new ArrayList<>();
    private ArrayList<Integer> choice = new ArrayList<>();
    private int sum = 0;

    private void makeList() {
        serviceList.add("Диагностика");
        serviceList.add("Замена лобового стекла");
        serviceList.add("Покраска кузова");
        serviceList.add("Ремонт двигателя");
        serviceList.add("Замена шины");
    }

    private void chooseServices() {
        showServiceList();

        int counter = 5;

        while (counter > 0) {
            Scanner scanner = new Scanner(System.in);
            int choiceNum = scanner.nextInt();

            if(choiceNum == 0) {
                counter = 0;
            }
            else {
                choice.add(choiceNum);
                counter--;
            }
        }

    }

    private void countPrice() {
        chooseServices();


        for(int k=0; k < choice.size(); k++) {
            sum = sum + price[k];
        }

        System.out.println("Сумма заказа: " + sum + " рублей.");
        System.out.println("Введите количество ваших денежных средств: ");
    }

    public void checkPrice() {
        countPrice();
        Scanner scanner = new Scanner(System.in);
        int amountOfMoney = scanner.nextInt();

        if(amountOfMoney < sum) {
            System.out.println("У вас недостаточно денежных средств на выбранные услуги. " +
                    "Хотите выбрать другие услуги?(y/n)");
            Scanner scanner1 = new Scanner(System.in);
            String serviceChoice = scanner1.nextLine();

            if(serviceChoice.equals("y")) {
                changeServices();
            }
            else if(serviceChoice.equals("n")) {
                System.out.println("Good bye!");
            }
        }
    }

    private void changeServices() {

    }

    private void showServiceList() {
        makeList();

        for (int i=0; i < price.length; i++) {
            System.out.println(serviceList.get(i) + " - " + price[i] + " рублей.");
        }

        System.out.println("Выберите услуги: ");
    }

}
