package allure.piechart.telegram;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class TelegramBot extends TelegramLongPollingBot {
    public TelegramBot() {
    }

    public void onUpdateReceived(Update update) {
    }

    public void sendPicture(SendPhoto sendPhoto) {
        try {
            this.execute(sendPhoto);
        } catch (TelegramApiException var3) {
            var3.printStackTrace();
        }

    }

    public String getBotUsername() {
        return null;
    }

    public String getBotToken() {
        return PieChartToTelegram.secretBot;
    }
}