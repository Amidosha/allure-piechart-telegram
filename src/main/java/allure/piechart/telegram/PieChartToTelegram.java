//"\n- продолжительность: " + buildDurationTime +


package allure.piechart.telegram;

import allure.piechart.telegram.models.Summary;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;
import org.knowm.xchart.BitmapEncoder;
import org.knowm.xchart.PieChart;
import org.knowm.xchart.BitmapEncoder.BitmapFormat;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import java.time.Duration;

public class PieChartToTelegram {
    static String piechartName = "piechart";
    static String resultsFilePath = "widgets/summary.json";
    public static String secretBot;

    public PieChartToTelegram() {
    }

    public static void main(String[] args) throws IOException {
        String chatId = args[0];
        secretBot = args[1];
        String projectName = args[2];
        String allureReportFolder = args[3];
        String buildLink = args[4];
        String launchName = args[5];
        String someUrl = args[6];
        String linkToAllureReport = buildLink + "allure";
        String fullResultsFilePath = allureReportFolder + resultsFilePath;
        ObjectMapper objectMapper = new ObjectMapper();
        Summary summaryResults = (Summary)objectMapper.readValue(new File(fullResultsFilePath), Summary.class);
        long failedResult = (long)summaryResults.getStatistic().getFailed();
        long brokenResult = (long)summaryResults.getStatistic().getBroken();
        long passedResult = (long)summaryResults.getStatistic().getPassed();
        long skippedResult = (long)summaryResults.getStatistic().getSkipped();
        long unknownResult = (long)summaryResults.getStatistic().getUnknown();
        long totalResult = (long)summaryResults.getStatistic().getTotal();
        long failedPercent = failedResult * 100L / totalResult;
        long passedPercent = passedResult * 100L / totalResult;
        //long buildDurationMilliseconds = summaryResults.getTime().getDuration();
        //String buildDurationTime = getTimeFromMilliseconds(buildDurationMilliseconds);
        String telegramMessage = "Результаты: " + launchName + "\n- всего сценариев в запуске: " + totalResult + "\n- рабочий стенд: " + someUrl + "\n- из них успешных: " + passedResult + "\n- из них упавших: " + failedResult + "\n" + (brokenResult > 0L ? "- из них сломано: " + brokenResult + "\n" : "") + (unknownResult > 0L ? "- из них упавших по неизвестной причине: " + unknownResult + "\n" : "") + "- из них пропущенных: " + skippedResult + "\n- % упавших тестов: " + failedPercent + "\n" + linkToAllureReport;
        PieChart chart = PieChartBuilder.getChart(summaryResults, projectName);

        try {
            BitmapEncoder.saveBitmap(chart, piechartName, BitmapFormat.PNG);
        } catch (IOException var34) {
            var34.printStackTrace();
        }

        TelegramBot myBot = new TelegramBot();
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setPhoto(new File(piechartName + ".png"));
        sendPhoto.setCaption(telegramMessage);
        sendPhoto.setChatId(chatId);
        myBot.sendPicture(sendPhoto);
    }

    public static String getTimeFromMilliseconds(Long milliseconds) {
        Date date = new Date(milliseconds);
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss.SSS");
        formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
        return formatter.format(date);
    }
}
