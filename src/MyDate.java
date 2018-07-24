import java.util.Date;

/*Extending java Data class to set required date to filter the data*/
public class MyDate extends Date {

    MyDate(int year, int month, int day){
        super(year-1900,month,day);
    }

    @Override
    public boolean equals(Object obj) {
        Date date = (Date) obj;
        return this.getYear() == date.getYear()
                && this.getMonth() == date.getMonth()
                && this.getDay() == date.getDay();
    }
}
