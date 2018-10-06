package com.dme.innchecker;

public class INNCheckApplication {
    public static void main(String[] args) {
        INNChecker INNChecker = new INNChecker();
        if (args.length > 0) {
            System.out.println(INNChecker.check(args[0]));
        } else
        {
            INNChecker.cliStart();
        }
    }
}