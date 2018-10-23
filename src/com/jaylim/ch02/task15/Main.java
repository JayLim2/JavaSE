package com.jaylim.ch02.task15;

public class Main {
    public static void main(String[] args) {
        task15();
    }

    /**
     * Chapter 2
     * Task 15
     */
    public static void task15() {
        Invoice invoice = new Invoice();

        invoice.addItem("test 1", 10, 1050);
        invoice.addItem("sfddfdsaf 2", 2, 733);
        invoice.addItem("fgfsd 3", 1, 211);
        invoice.addItem("egjfsgk", 5, 54);

        invoice.printInvoice();
    }
}
