package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Category {
    BREAKFAST("Śniadania:", "Śniadanie to najważniejszy posiłek dnia, dlatego w tym miejscu znajdziesz najróżniejsze przepisy na przepyszne śniadanie."),
    DINNER("Obiady:", "Szukasz pomysłu na obiad? To idealne miejsca dla ciebie! W tej zakładce znajdują się inspiracje na smakowite przepisy dań obiadowych."),
    DESSERT("Desery:", "Słodka przerwa w ciągu dnia przyda się każdemu. Te miejsce jest idealne, aby znaleźć pyszny przepis na małe co nieco"),
    SNACK("Przekąski:", "Jesteś głodny, ale nie masz czasu gotować? Ta zakładka charakteryzuje się smacznymi przepisami na proste i szybkie przekąski."),
    SUPPER("Kolacje:", "Na koniec dnia także przyda się pyszny przepis na lekką oraz uroczystą kolacje. W tej zakładce na pewno znajdziesz coś dla siebie!"),
    DRINK("Napoje:", "Szukasz pysznych  przepisów na kawy, napoje bezalkoholowe lub alkoholowe? Będziesz zachwycony tą zakładką. Tutaj na pewno znajdziesz coś dla siebie!"),
    ALL("Wszystkie:", "Szukasz pomysłu na danie, ale nie wiesz co chcesz zjeść? To idealne miejsca dla ciebie! W tej zakładce znajdują się inspiracje na smakowite przepisy wszystkich rodzai dań."),
    RATING("Najlepiej oceniane:", "Szukasz pomysłu na danie, ale nie wiesz co chcesz zjeść? To idealne miejsca dla ciebie! W tej zakładce znajdują się nasze najlepsze przepisy");

    private String title;
    private String description;
}