package ru.geekbrains.lesson8.models;

import ru.geekbrains.lesson8.presenters.Model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;

public class TableModel implements Model {


    private Collection<Table> tables;
    private final Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Получение списка всех столиков
     */
    public Collection<Table> loadTables(){

        if (tables == null){
            tables = new ArrayList<>();
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
            tables.add(new Table());
        }

        return tables;
    }

    /**
     * Бронирование столика
     * @param reservationDate Дата бронирования
     * @param tableNo Номер столика
     * @param name Имя
     */
    @Override
    public int reservationTable(Date reservationDate, int tableNo, String name) {
        for (Table table: tables) {
            if (table.getNo() == tableNo){
                Reservation reservation = new Reservation(table, reservationDate, name);
                reservations.add(reservation);
                return reservation.getId();
            }
        }
        throw new RuntimeException("Ошибка бронирования столика. Повторите попытку позже.");
    }

    /**
     * TODO: Доработать самостоятельнов рамках домашней работы
     * @param oldReservation
     * @param reservationDate
     * @param tableNo
     * @param name
     * @return
     */
    @Override
    public void changeReservationTable(int oldReservation, Date reservationDate, int tableNo, String name){

        Reservation reservation = reservations.stream().filter(reserv -> reserv.getId()==oldReservation)
                .findFirst().orElseThrow(() -> new RuntimeException(String.format("Резерв %s не найден", oldReservation)));

        if (Objects.nonNull(reservationDate)) {
            if (reservationDate.before(new Date())) throw new RuntimeException("Дата резерва раньше текущей");
            reservation.setDate(reservationDate);
        }

        if (Objects.nonNull(tableNo)) {
            Table newTable = tables.stream().filter(table -> table.getNo()==tableNo)
                    .findFirst().orElseThrow(() -> new RuntimeException(String.format("Столик %s не найден", tableNo)));
            reservation.setTable(newTable);
        }

        if (Objects.nonNull(name)) reservation.setName(name);
    }

}
