import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        List<Company> companies = gson.fromJson(new FileReader(new File("test.json")),
                new TypeToken<List<Company>>() {
                }.getType());

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern(
                "[dd.MM.yyyy]"
                        + "[dd.MM.yy]"
                        + "[dd/MM/yyyy]"
                        + "[dd/MM/yy]"
        );

        System.out.println("Все компании:\n");
        companies.forEach(System.out::println);

        System.out.println("\nУкажите дату:");
        LocalDate date = LocalDate.parse(sc.nextLine(), dateFormat);

        System.out.println("\nОрганизации,основанные после введенной даты:\n");
        companies.stream()
                .filter(company -> LocalDate.parse(company.getCompanyDate(), dateFormat).isAfter(date))
                .forEach(company -> System.out.println(company.getNameFull() + " " + company.getCompanyDate()));

        AtomicInteger sum = new AtomicInteger();
        System.out.println("\nПросроченные бумаги:\n");
        companies.forEach(
                company -> company.getList().stream().filter(
                        companySecurity -> LocalDate.parse(companySecurity.getDate()).isBefore(LocalDate.now())
                )
                        .forEach(companySecurity -> System.out.println(companySecurity.toString()
                                + "\n" + sum.addAndGet(companySecurity.getCount() + 1)))
        );

        System.out.println("\nУкажите код валюты:\n");
        String currencyCode = sc.nextLine();

        companies.forEach(
                company -> company.getList().stream().filter(
                        companySecurity -> companySecurity.getCurrency().getCode().equals(currencyCode))
                        .forEach(companySecurity -> System.out.println(companySecurity.getId() + " "
                        + companySecurity.getCode())
                ));
    }
}
