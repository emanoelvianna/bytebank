package com.bytebank;


import com.bytebank.model.Acount;
import com.bytebank.model.Person;
import com.bytebank.service.AcountService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    public static void main(String[] args) {
        Person emanoel = new Person("Emanoel Vianna",
                "142.135.090-44",
                LocalDate.of(1993, 1, 22),
                "91270-010",
                "vianna@gmail.com");
        Acount acount = new Acount(emanoel);

        AcountService service = new AcountService();
        service.deposit(acount, new BigDecimal(100));

        System.out.println(acount.toString());
    }

}