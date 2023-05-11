package io.efficientsoftware.simplebookscli.model;

import io.efficientsoftware.simplebookscli.model.core.DateEvent;
import lombok.Getter;
import lombok.ToString;


@ToString
@Getter
public class MileageEvent extends DateEvent {

    private String vehicleName;
    private Double milesDriven;
    private String description;

    public MileageEvent(String date, String vehicleName, String milesDriven, String description) {
        super(date);
        this.vehicleName = vehicleName;
        this.milesDriven = parseDouble(milesDriven);
        this.description = description;
        this.eventType = EVENT_TYPE.MILEAGE;
    }

    public MileageEvent(String[] csv) {
        this(csv[1],csv[2],csv[3],csv[4]);
    }

    @Override
    public String toCSV() {
        return EVENT_TYPE.MILEAGE.toString() + "," + dateToString(date) + "," +
                vehicleName + "," + milesDriven.toString() + "," + description;
    }

}
