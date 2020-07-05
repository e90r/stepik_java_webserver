package accounts;

import dbService.DBException;
import dbService.DBService;
import dbService.dataSets.UsersDataSet;

import java.util.HashMap;
import java.util.Map;

/**
 * @author v.chibrikov
 *         <p>
 *         Пример кода для курса на https://stepic.org/
 *         <p>
 *         Описание курса и лицензия: https://github.com/vitaly-chibrikov/stepic_java_webserver
 */
public class AccountService {
//    private final Map<String, UsersDataSet> loginToProfile;
//    private final Map<String, UsersDataSet> sessionIdToProfile;
    private final DBService dbService;

    public AccountService() {
//        loginToProfile = new HashMap<>();
//        sessionIdToProfile = new HashMap<>();
        dbService = new DBService();
    }

    public void addNewUser(String login, String password) {
        //loginToProfile.put(usersDataSet.getLogin(), usersDataSet);

        dbService.printConnectInfo();
        try {
            long userId = dbService.addUser(login, password);
            System.out.println("Added user id: " + userId);

            UsersDataSet dataSet = dbService.getUser(userId);
            System.out.println("User data set: " + dataSet);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    public UsersDataSet getUserByLogin(String login) {
        //return loginToProfile.get(login);
        dbService.printConnectInfo();

        UsersDataSet user = null;
        try {
            user = dbService.getUserByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }

        return user;
    }

//    public UsersDataSet getUserBySessionId(String sessionId) {
//        return sessionIdToProfile.get(sessionId);
//    }
//
//    public void addSession(String sessionId, UsersDataSet usersDataSet) {
//        sessionIdToProfile.put(sessionId, usersDataSet);
//    }
//
//    public void deleteSession(String sessionId) {
//        sessionIdToProfile.remove(sessionId);
//    }
}
