package consonants.flex.use_case.login;

public class LoginInputData {
    final private int clientId;

    public LoginInputData(int clientId) { this.clientId = clientId; }

    int getClientId() { return clientId; }
}
