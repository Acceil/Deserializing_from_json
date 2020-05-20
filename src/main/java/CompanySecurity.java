import com.google.gson.annotations.SerializedName;

import java.time.LocalDate;

public class CompanySecurity {
    private int id;
    @SerializedName("name_full")
    private String nameFull;
    @SerializedName("date_to")
    private String date;
    private int count;
    @SerializedName("currency")
    private Currency currency;
    private String code;

    public CompanySecurity(String code, String date) {
        this.nameFull = code;
        this.date = date;
    }

    @Override
    public String toString() {
        return nameFull + '\'' +
                ", дата просрочки: " + dateFormat(date);
    }

    public static LocalDate dateFormat(String date) {
        return LocalDate.parse(date);
    }

    public int getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
