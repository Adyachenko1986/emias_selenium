package pages.sql;

import io.qameta.allure.Step;
import org.codehaus.plexus.util.IOUtil;
import pages.AbstractPage;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.util.List;

//import system.model.HltDispExamEntity;

public class SQLDemonstration extends AbstractPage {
    private static String connectionUrl = "jdbc:sqlserver://12.8.1.66";
    private static String databaseName = "hlt_demonstration";
    private static String userName = "sa";
    private static String password = "sagfhjkzYES!";
    private static List<File> lst;

    @Step("удаляю расписание этого врача")
    public static void deleteShedule(String fam) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "AND ldoc.FAM_V = '" + fam + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("удаляю расписание этого врача")
    public static void deleteShedule(int LPUDoctorID, int DocPRVDID) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable dtt left outer join hlt_LPUDoctor ldoc " +
                                "on dtt.rf_LPUDoctorID = ldoc.LPUDoctorID " +
                                "where dtt.Date >= DATEADD(dd, ((DATEDIFF(dd, '17530101', GETDATE()) / 7) * 7) - 7, '17530101') " +
                                "  AND dtt.rf_DocPRVDID = " + DocPRVDID +
                                "  AND dtt.rf_LPUDoctorID = " + LPUDoctorID;
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
        System.out.println("Удалил расписание у LPUDoctorID: " + LPUDoctorID + " DocPRVDID: " + DocPRVDID);
    }

    @Step("завершаю все существующие вызовы")
    public static void finalizeAllCalls() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor set rf_calldoctorstatusid = 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы оператора Темников")
    public static void finalizeCallsOperatorTemnikov() {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_calldoctor " +
                                "set rf_calldoctorstatusid = 3 " +
                                "from hlt_calldoctor cl " +
                                "inner join oms_DocumentHistory dh on cl.guid = dh.rf_documentguid " +
                                "where dh.Editor = 'Темников Дмитрий Олегович' " +
                                "and cl.rf_calldoctorstatusid in (2, 5, 7)";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы этого врача")
    public static void finalizeCallLpuDoctor(String doctorName) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
//                        "update hlt_CallDoctor " +
//                                "set rf_CallDoctorStatusID = 3 " +
//                                "from hlt_CallDoctor cd  inner join hlt_LPUDoctor ldoc on cd.rf_LPUDoctorID = ldoc.LPUDoctorID " +
//                                "where ldoc.FAM_V = '" + doctorName + "'";
                        "update " +
                                "hlt_CallDoctor " +
                                "set " +
                                "rf_CallDoctorStatusID = 3 " +
                                "from hlt_LPUDoctor ldoc " +
                                "inner join hlt_DocPRVD dvd on ldoc.LPUDoctorID = dvd.rf_LPUDoctorID " +
                                "inner join hlt_CallDoctor cd on cd.rf_DocPRVDID = dvd.DocPRVDID " +
                                "where ldoc.FAM_V = '" + doctorName + "' and " +
                                "cd.rf_CallDoctorStatusID != 3";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Doctor: " + doctorName + " is finalize.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы пациента по имени")
    public static void finalizePacientName(String pacientName) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where Name = '" + pacientName + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + pacientName + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }

    @Step("завершаю вызовы пациента по полису")
    public static void finalizeCall_NPol(String number) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "update hlt_CallDoctor " +
                                "set rf_CallDoctorStatusID = 3 " +
                                "where numberPol = '" + number + "'";

                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Pacient - " + number + " finalize is done.");
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
        System.out.println("Вызов завершен для портала!");
    }

    @Step("Сбросить мероприятия у карты вызова")
    public static void setDefaultServices(String cardID) { // TODO: 04.09.2018 доделать обнуление заключения
//        HltDispExamService hltDispExamService = new HltDispExamService();
//        HltDispExamEntity hltDispExamEntity = new HltDispExamEntity();
//        hltDispExamEntity.setFlags(1);
//        hltDispExamService.saveExam(hltDispExamEntity);
//
//        Query query = session.createQuery("select * from HltDispExamEntity");
//        query.setParameter("id", "255");
//        List list = query.list();

//        String url = connectionUrl +
//                ";databaseName=" + databaseName +
//                ";user=" + userName +
//                ";password=" + password;
//        try {
//            System.out.print("Connecting to SQL Server ... ");
//            try (Connection connection = DriverManager.getConnection(url)) {
//                String sql =
//                        "update hlt_disp_Exam" +
//                                " set IsDeviation = 0," +
//                                " IsOtkaz = 0," +
//                                " IsSigned = 0" +
//                                " from hlt_disp_Card dc" +
//                                " inner join hlt_disp_Exam de on dc.Guid = de.rf_CardGuid" +
//                                " where dc.disp_CardID = '" + cardID + "'";
//                try (Statement statement = connection.createStatement()) {
//                    statement.executeUpdate(sql);
//                    System.out.println("Card: " + cardID + " is default!");
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void runSqlScript(String sql) throws IOException {
        InputStream is = new FileInputStream("src/main/resources/sql/disp/" + sql);
        String script = IOUtil.toString(is, "UTF-8");
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    System.out.println("SQL scripst " + sql + " Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Запуск скрипта на демонстрейшн")
    public static void scriptTxt(String script) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(script);
                    System.out.println("SQL scripst Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void scriptsToCalldoctor() throws IOException {
        File dir = new File("src/main/resources/sql/calldoctor");
        File[] files = dir.listFiles();
        File[] scriptList = files;
        for (File scriptPath : scriptList) {
            InputStream is = new FileInputStream(scriptPath);
            String script = IOUtil.toString(is, "UTF-8");
            scriptTxt(script);
        }
    }

    @Step("Создаю расписание для врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void createShedule(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
        String request = new DateGenerator().dispDoctorShedule(LPUDoctorID, DocPRVDID);
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    System.out.println("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Создаю расписание для врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void createSheduleCD(int LPUDoctorID, int DocPRVDID) throws FileNotFoundException, ParseException {
        String request = new DateGenerator().dispDoctorSheduleCD(LPUDoctorID, DocPRVDID);
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(request);
                    System.out.println("Complete!");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Удаляю расписание врача {docprvdid} (Ай Бо Лит АвтоТест)")
    public static void deleteSheduleByPrvdid(String docprvdid) {
        String url = connectionUrl +
                ";databaseName=" + databaseName +
                ";user=" + userName +
                ";password=" + password;
        try {
            System.out.print("Connecting to SQL Server ... ");
            try (Connection connection = DriverManager.getConnection(url)) {
                String sql =
                        "delete hlt_DoctorTimeTable from hlt_DoctorTimeTable where rf_DocPRVDID = '1285'";
                try (Statement statement = connection.createStatement()) {
                    statement.executeUpdate(sql);
                    System.out.println("Table DTT is clean.");
                    statement.close();
                }
            }
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
        }
    }
}