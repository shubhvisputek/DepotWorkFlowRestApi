package com.aurusinc.depotworkflow.restapi.util;

import java.util.ArrayList;
import java.util.List;

public class DeviceUtility {

    List<String> unusedListDummyTID = new ArrayList<String>();
    List<String> usedListDummyTID = new ArrayList<String>();

    private static DeviceUtility obj=new DeviceUtility(); 

    private DeviceUtility() {

        // unusedListDummyTID.add("64924769");
        // unusedListDummyTID.add("65663822");
        // unusedListDummyTID.add("70738987");
        // unusedListDummyTID.add("89705893");
        // unusedListDummyTID.add("90588191");
        // unusedListDummyTID.add("13994699");
        // unusedListDummyTID.add("75796357");
        // unusedListDummyTID.add("18208577");
        // unusedListDummyTID.add("82611396");

        // unusedListDummyTID.add("59821212");
        // unusedListDummyTID.add("29331184");
        // unusedListDummyTID.add("12668633");
        // unusedListDummyTID.add("64164146");
        // unusedListDummyTID.add("65615985");
        // unusedListDummyTID.add("57245763");
        // unusedListDummyTID.add("25411339");
        unusedListDummyTID.add("51470846");
        unusedListDummyTID.add("70859493");

        unusedListDummyTID.add("68329458");
        unusedListDummyTID.add("28582440");
        unusedListDummyTID.add("72525097");
        unusedListDummyTID.add("60153394");
        unusedListDummyTID.add("45288953");
        unusedListDummyTID.add("80382655");
        unusedListDummyTID.add("21915522");
        unusedListDummyTID.add("60237224");
        unusedListDummyTID.add("49057970");



    } 

    public static DeviceUtility getDeviceUtility(){
        return obj;
    }

    
    public String getDummyTID() {
        String dummyTID = unusedListDummyTID.remove(0);
        usedListDummyTID.add(dummyTID);
        return dummyTID;
    }

}
