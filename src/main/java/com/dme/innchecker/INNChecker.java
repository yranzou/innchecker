package com.dme.innchecker;

import unisoft.ws.FNSNDSCAWS2;
import unisoft.ws.FNSNDSCAWS2Port;
import unisoft.ws.fnsndscaws2.request.NdsRequest2;
import unisoft.ws.fnsndscaws2.response.NdsResponse2;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


class INNChecker {

    private FNSNDSCAWS2Port fnsndscaws2Port;
    private NdsRequest2 ndsRequest2;
    private NdsRequest2.NP np;
    private static final SimpleDateFormat DT = new SimpleDateFormat("dd.MM.yyyy");

    INNChecker() {
        fnsndscaws2Port = new FNSNDSCAWS2().getFNSNDSCAWS2Port();
        ndsRequest2 = new NdsRequest2();
        np = new NdsRequest2.NP();
        ndsRequest2.getNP().add(np);
    }

    String check(String inn) {
        np.setINN(inn);
        np.setDT(DT.format(new Date()));
        NdsResponse2 ndsResponse2 = fnsndscaws2Port.ndsRequest2(ndsRequest2);
        List<NdsResponse2.NP> list = ndsResponse2.getNP();
        return list.get(0).getState();
    }

    void cliStart() {
        Scanner sc = new Scanner(System.in);
        String input;
        while (true) {
            if (sc.hasNext()) {
                input = sc.next();
                if (input.equals("exit") || input.equals("quit")) {
                    break;
                }
                System.out.println(check(input));
            }
        }
    }
}