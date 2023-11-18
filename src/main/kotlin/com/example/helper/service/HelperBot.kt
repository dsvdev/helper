package com.example.helper.service

import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.api.methods.send.SendMessage
import org.telegram.telegrambots.meta.api.objects.Update

class HelperBot(botUsername : String, botToken : String) : TelegramLongPollingBot(botToken) {
    private val username : String
    init {
        this.username = botUsername
    }
    override fun getBotUsername(): String {
        return username
    }

    override fun onUpdateReceived(update: Update?) {
        if (update == null) {
            return;
        }
        var message : SendMessage = SendMessage();
        message.chatId = update.message.chatId.toString()
        message.text = update.message.text;
        execute(message)
    }
}