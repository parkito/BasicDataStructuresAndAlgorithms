package exersByMe.dataForExers;

import java.util.Collection;

/**
 * @author Artem Karnov @date 17.02.2017.
 *         artem.karnov@t-systems.com
 */

public class Work {
    private String company;
    private long employersNumber;
    private Collection<Citizen> employersList;

    public Work(String company, long employersNumber, Collection<Citizen> employersList) {
        this.company = company;
        this.employersNumber = employersNumber;
        this.employersList = employersList;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmployersNumber(long employersNumber) {
        this.employersNumber = employersNumber;
    }

    public void setEmployersList(Collection<Citizen> employersList) {
        this.employersList = employersList;
    }

    public String getCompany() {
        return company;
    }

    public long getEmployersNumber() {
        return employersNumber;
    }

    public Collection<Citizen> getEmployersList() {
        return employersList;
    }
}
