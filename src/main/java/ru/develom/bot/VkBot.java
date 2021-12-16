package ru.develom.bot;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageNew;

import api.longpoll.bots.model.objects.basic.Message;

import java.util.Arrays;
public class VkBot extends LongPollBot {

    public String[] helloList = {"Здравствуйте","Подскажи","привет","Привет","Здравствуйте!"};

    public boolean helloCheck(String inputMessage){
        boolean hello=false;
        for (String splitMessage : inputMessage.split(" ")) {
            hello = Arrays.asList(helloList).contains(splitMessage.toLowerCase());
            if (hello) {
                break;}
        }
        return hello;}



    @Override
    public void onMessageNew(MessageNew messageNew) {
        try {
        Message message=messageNew.getMessage();
        if(message.getText().contains("Показания")) {
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Введите показания  в формате Лицевой счет пробел показания")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        else if (message.getText().contains("Акции")){
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Акция списания пени  до 15 января ")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        else if (message.getText().contains("Оператор")){
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Всегда можно написать  на наш электронный адрес:  GMK_Sochi_Upr@KRK-RG.RU ")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        else if (helloCheck(message.getText())){
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Добро пожаловать в чат Бот помошник пока учиться но возможно он ответит на ваш вопрос ")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();


        }else if (message.getText().contains("Здравствуйте")) {
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Добро пожаловать в чат Бот помошник пока учиться но возможно он ответит на ваш вопрос")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        else if (message.getText().contains("Добрый день")) {
            vk.messages.send()
                    .setPeerId(message.getPeerId())
                    .setMessage("Добро пожаловать в чат Бот помощник пока учится но возможно он ответит на ваш вопрос")
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        else {
            vk.messages.send().setMessage("Я пока этого не знаю напишите оператору или дождитесь ответа Человека  ")
                    .setPeerId(message.getPeerId())
                    .setKeyboard(Key.getSimpleKeyboard())
                    .execute();
        }
        }catch (VkApiException e){
            e.printStackTrace();
        }
    }
    @Override
    public String getAccessToken() {
        return "4b2d15c5d98d9e5a9a01e0acc80b24e05b26568dfd21d89042aebb1194bbf6dfbfb718d1611ad5f9ec84f";
    }

    @Override
    public int getGroupId() {
        return 193821485;
    }

    public static void main(String[] args)throws VkApiException {
        new VkBot().startPolling();

    }
}