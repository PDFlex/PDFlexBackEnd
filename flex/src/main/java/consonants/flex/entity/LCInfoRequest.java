package consonants.flex.entity;

import java.util.ArrayList;

public class LCInfoRequest extends Form{

    // **** claims checklist
    private boolean completedDeathCertificate;
    private boolean attachedDeathCertificate;
    private boolean completedClaimSubmission;

    // **** deceased info
    private String dateOfBirth;

    // **** medical info
    private String causeOfDeath;
    private boolean deceasedHospitalized;  // if true , we need the date of hospitalization
    private String hospitalName;
    private String hospitalAddress;
    private ArrayList<String> pastPhysicianNames;
    private ArrayList<String> pastPhysicianAddresses;

    // ****** attending physician info
    private String attendingPhysicianName;
    private String attendingPhysicianAddress;
    private String attendingPhysicianContactNumber;

    // ****** family physician info
    private String familyPhysicianName;
    private String familyPhysicianAddress;
    private String familyPhysicianContactNumber;

    // **** employment info
    private String occupation;
    private String employer;
    private String dateLastWorked;
    private String workAddress;
    private String employerContactNumber;
    private String reasonInsuredStoppedWorking;

    // **** kin info
    private String nameOfKin;
    private String kinAddress;
    private String relationshipToInsured;
    private String kinContactNumber;
    private String kinSignature;

    public LCInfoRequest(int formId, int claimId, int clientId, String deceasedName, String dateOfDeath, String dateSigned, String dateOfBirth, boolean completedDeathCertificate, boolean attachedDeathCertificate, boolean completedClaimSubmission, String causeOfDeath, boolean deceasedHospitalized, String hospitalName, String hospitalAddress, String attendingPhysicianName, String attendingPhysicianAddress, String attendingPhysicianContactNumber, ArrayList<String> pastPhysicianNames, ArrayList<String> pastPhysicianAddresses, String familyPhysicianName, String familyPhysicianAddress, String familyPhysicianContactNumber, String occupation, String employer, String dateLastWorked, String workAddress, String employerContactNumber, String reasonInsuredStoppedWorking, String nameOfKin, String kinAddress, String relationshipToInsured, String kinContactNumber, String kinSignature) {
        super(formId, claimId, clientId, deceasedName, dateOfDeath, dateSigned);
        this.dateOfBirth = dateOfBirth;
        this.completedDeathCertificate = completedDeathCertificate;
        this.attachedDeathCertificate = attachedDeathCertificate;
        this.completedClaimSubmission = completedClaimSubmission;
        this.causeOfDeath = causeOfDeath;
        this.deceasedHospitalized = deceasedHospitalized;
        this.hospitalName = hospitalName;
        this.hospitalAddress = hospitalAddress;
        this.attendingPhysicianName = attendingPhysicianName;
        this.attendingPhysicianAddress = attendingPhysicianAddress;
        this.attendingPhysicianContactNumber = attendingPhysicianContactNumber;
        this.pastPhysicianNames = pastPhysicianNames;
        this.pastPhysicianAddresses = pastPhysicianAddresses;
        this.familyPhysicianName = familyPhysicianName;
        this.familyPhysicianAddress = familyPhysicianAddress;
        this.familyPhysicianContactNumber = familyPhysicianContactNumber;
        this.occupation = occupation;
        this.employer = employer;
        this.dateLastWorked = dateLastWorked;
        this.workAddress = workAddress;
        this.employerContactNumber = employerContactNumber;
        this.reasonInsuredStoppedWorking = reasonInsuredStoppedWorking;
        this.nameOfKin = nameOfKin;
        this.kinAddress = kinAddress;
        this.relationshipToInsured = relationshipToInsured;
        this.kinContactNumber = kinContactNumber;
        this.kinSignature = kinSignature;
    }
}
