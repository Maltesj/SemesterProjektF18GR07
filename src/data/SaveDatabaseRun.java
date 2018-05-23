/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import acquaintance.IActionplan;
import acquaintance.IAssessment;
import acquaintance.ICaseInformation;
import acquaintance.IWork;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Simon
 */
public class SaveDatabaseRun implements Runnable {

    private String caseID;
    private Map<String, Serializable> blobMaaap;

    SaveDatabaseRun(IWork work, ICaseInformation caseInfo, IAssessment assessment, IActionplan actionplan, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put("work", work);
        this.blobMaaap.put("caseInfo", caseInfo);
        this.blobMaaap.put("assessment", assessment);
        this.blobMaaap.put("actionplan", actionplan);

    }

    SaveDatabaseRun(ICaseInformation caseInfo, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put("caseInfo", caseInfo);
    }

    SaveDatabaseRun(IAssessment assessment, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put("assessment", assessment);
    }

    SaveDatabaseRun(IActionplan actionplan, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put("actionplan", actionplan);
    }

    SaveDatabaseRun(IWork work, String caseID) {
        this.caseID = caseID;

        this.blobMaaap = new HashMap<>();
        this.blobMaaap.put("work", work);
    }

    @Override
    public void run() {

        try {
            Class.forName("assets/org.postgresql.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e);
        }

        try (Connection db = DriverManager.getConnection(EnumDatabaseAccount.ACCOUNT1.url, EnumDatabaseAccount.ACCOUNT1.userName, EnumDatabaseAccount.ACCOUNT1.password)) {
            for (Map.Entry<String, Serializable> entry : this.blobMaaap.entrySet()) {
                Blob blob = db.createBlob();
                ByteArrayOutputStream d = new ByteArrayOutputStream();
                ObjectOutputStream bs = new ObjectOutputStream(d);
                bs.writeObject(entry.getValue());
                bs.flush();
                blob.setBytes(0, d.toByteArray());

                PreparedStatement prepared = db.prepareStatement("Update Cases Set Last_changed = getDate(), " + entry.getKey() + "= ? where caseID = ?");
                prepared.setBlob(1, blob);
                prepared.setString(2, caseID);
                prepared.execute();
            }

        } catch (Exception e) {
            System.out.println(e);

        }

    }

}
