package com.desin.kelala.restkelala.entity;

import java.util.List;

public class Sale {

    private User user;
    private HealthRepresentative healthRepresentative;
    private List<Deduction> deductions;
    private Company company;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public HealthRepresentative getHealthRepresentative() {
        return healthRepresentative;
    }

    public void setHealthRepresentative(HealthRepresentative healthRepresentative) {
        this.healthRepresentative = healthRepresentative;
    }

    public List<Deduction> getDeductions() {
        return deductions;
    }

    public void setDeductions(List<Deduction> deductions) {
        this.deductions = deductions;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
