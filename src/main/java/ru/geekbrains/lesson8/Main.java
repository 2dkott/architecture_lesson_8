package ru.geekbrains.lesson8;

import ru.geekbrains.lesson8.models.TableModel;
import ru.geekbrains.lesson8.presenters.BookingPresenter;
import ru.geekbrains.lesson8.presenters.Model;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.views.BookingView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Main {

    /**
     * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        presenter.updateUIShowTables();

        view.reservationTable(new Date(), 2, "Станислав");

        view.changeReservationTable(1001, new Date(2024, 2, 2), 3, "Станислав");

        //Проверить дату резерва
        //LocalDate date = LocalDate.of(2022, 1, 1);
        //ZoneId defaultZoneId = ZoneId.systemDefault();
        //view.changeReservationTable(1001, Date.from(date.atStartOfDay(defaultZoneId).toInstant()), 3, "Станислав");

        //Проверить номер резерав
        //view.changeReservationTable(101, new Date(), 3, "Станислав");

        //Проверить номер столика
        //view.changeReservationTable(1001, new Date(), 30, "Станислав");

    }

}
