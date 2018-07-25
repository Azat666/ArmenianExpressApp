package com.example.student.arminianexpresapp.proviader;

import com.example.student.arminianexpresapp.models.ProduktModel;

import java.util.ArrayList;
import java.util.List;

public class UserProvider {
    public static List<ProduktModel> list = new ArrayList<>();
    public static int position;

    public static List<ProduktModel> returnFavorites() {
        final List<ProduktModel> listForReturn = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isliked) {
                listForReturn.add(list.get(i));
            }
        }
        return listForReturn;
    }

    public static List<ProduktModel> returnInBasket() {
        final List<ProduktModel> listForReturn = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).isToBasket) {
                listForReturn.add(list.get(i));
            }
        }
        return listForReturn;
    }

    public static List<ProduktModel> returnByType(String type) {
        final List<ProduktModel> listForReturn = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType().equals(type)) {
                listForReturn.add(list.get(i));
            }
        }
        return listForReturn;
    }

}
