package consonants.flex.entity;

import java.util.ArrayList;

public class Client {

    private ArrayList<Claim> claimsList; // Not final because it changes
    private final int id;
    private final String firstName;
    private final String lastName;

    Client(ArrayList<Claim> claimsList, int id, String firstName, String lastName){
        this.claimsList = claimsList;
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // @ Override? (See CA CommonUser.java)
    public ArrayList<Claim> getClaims(){return claimsList;}

    public Claim getClaim(int claimId){
        // TODO
        return null;
    }

    public void deleteClaim(int claimId){
        // Reconsider the return type. Return the claim that was deleted? Return a String with "sucesss" or "failure?"
        // TODO
    }



}
