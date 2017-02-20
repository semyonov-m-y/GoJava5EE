package module2_jdbc.home_work;

import module2_jdbc.home_work.entry.Company;
import module2_jdbc.home_work.jdbc.CompaniesDAO;

public class Main {
    public static void main(String[] args) {
        CompaniesDAO companiesDAO = new CompaniesDAO();
        companiesDAO.getAllCompanies().forEach(System.out::println);

        System.out.println("***************************************");
        System.out.println(companiesDAO.getByName("nix"));


        System.out.println("***************************************");
        companiesDAO.addCompany(new Company("TEst1"));
        companiesDAO.addCompany(new Company("TEst2"));
        companiesDAO.addCompany(new Company("TEst3"));
        companiesDAO.getAllCompanies().forEach(System.out::println);

        System.out.println("***************************************");
        companiesDAO.deleteByName("Test");
        companiesDAO.getAllCompanies().forEach(System.out::println);

        System.out.println("***************************************");
        companiesDAO.getCompaniesProjects(companiesDAO.getByName("Nix")).forEach(System.out::println);

    }

}
