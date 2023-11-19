package com.example.helper.config

import com.example.helper.service.HelperBot
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.telegram.telegrambots.bots.TelegramLongPollingBot
import org.telegram.telegrambots.meta.TelegramBotsApi
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession

@Configuration
class BotConfig {
    @Value("\${bot.credentials.username}")
    private lateinit var botUsername : String
    @Value("\${bot.credentials.token}")
    private lateinit var botToken : String


    @Bean
    fun helperBot() : TelegramLongPollingBot {
        return HelperBot(botUsername, botToken)
    }

    @Bean
    fun telegramBotsApi() : TelegramBotsApi {
        val api : TelegramBotsApi = TelegramBotsApi(DefaultBotSession::class.java)
        api.registerBot(helperBot())
        return api
    }
}