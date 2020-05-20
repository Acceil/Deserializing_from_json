import com.google.gson.annotations.SerializedName;

import java.util.Collection;


public class Company {
    private final int id;
    private String code;
    @SerializedName("name_full")
    private String nameFull;
    @SerializedName("egrul_date")
    private String companyDate;
    @SerializedName("securities")
    private final Collection<CompanySecurity> securities;


    public Company(int id, String code, String nameFull, String companyDate, Collection<CompanySecurity> securities) {
        this.id = id;
        this.code = code;
        this.nameFull = nameFull;
        this.companyDate = companyDate;
        this.securities = securities;
    }

    @Override
    public String toString() {
        return "Аббревиатура: " + code + '\''
                + ", Дата основания: " + companyDate;
    }

    public Collection<CompanySecurity> getList() {
        return securities;
    }

    public String getCompanyDate() {
        return companyDate;
    }

    public void setCompanyDate(String companyDate) {
        this.companyDate = companyDate;
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

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }
}
