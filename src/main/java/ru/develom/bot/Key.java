package ru.develom.bot;
import api.longpoll.bots.model.objects.additional.Keyboard;

import api.longpoll.bots.model.objects.additional.Template;

import api.longpoll.bots.model.objects.additional.buttons.*;

import api.longpoll.bots.LongPollBot;
import api.longpoll.bots.exceptions.VkApiException;
import api.longpoll.bots.model.events.messages.MessageNew;
import api.longpoll.bots.model.objects.basic.Message;
import api.longpoll.bots.model.objects.additional.carousel.Carousel;

import api.longpoll.bots.model.objects.additional.carousel.Element;

import com.google.gson.JsonObject;

import java.util.Arrays;

import java.util.List;

public class Key {

   // public static JsonObject negativeButtonPayloadPayload1 = new JsonObject();

   // public static Button back = new TextButton(Button.Color.NEGATIVE, new TextButton.Action(

     //       "Кнопки",

       //     negativeButtonPayloadPayload1

    //));
    //public static List<Button> rowBack = Arrays.asList(back);
    public static Keyboard getSimpleKeyboard() {

        JsonObject positiveButtonPayload = new JsonObject();

        Button positiveButton = new TextButton(Button.Color.POSITIVE, new TextButton.Action(

                "Показания",

                positiveButtonPayload));


        JsonObject negativeButtonPayload = new JsonObject();

        Button negativeButton = new TextButton(Button.Color.NEGATIVE, new TextButton.Action(

                "Акции",

                negativeButtonPayload));

        //JsonObject primaryButtonPayload = new JsonObject();

        //Button primaryButton = new TextButton(Button.Color.PRIMARY, new TextButton.Action(

          //      "CallBack",

          //      primaryButtonPayload));

       // JsonObject secondaryButtonPayload = new JsonObject();

       // Button secondaryButton = new TextButton(Button.Color.SECONDARY, new TextButton.Action(

         //       "Карусель",

         //       secondaryButtonPayload));

        JsonObject secondaryButtonPayload1 = new JsonObject();

        Button secondaryButton1 = new TextButton(Button.Color.SECONDARY, new TextButton.Action(

                "Оператор",

                secondaryButtonPayload1));

        List<Button> row1 = Arrays.asList(positiveButton, negativeButton);

       // List<Button> row2 = Arrays.asList(primaryButton, secondaryButton);

        List<Button> row3 = Arrays.asList(secondaryButton1);

        Keyboard keyboard = new Keyboard(Arrays.asList(row1,  row3));

        return keyboard;

    }
}