package com.example.mobileapp.payment;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
    @Entity
    public class payment {

        @Id
        @GeneratedValue
        private Integer id;
        private String type;
        private LocalDate paymentDate;
        public payment() {
            super();
        }
        public payment(Integer id, String type, LocalDate payementDate) {
            super();
            this.id = id;
            this.type = type;
            this.paymentDate = payementDate;
        }
        public Integer getId() {
            return id;
        }
        public void setId(Integer id) {
            this.id = id;
        }
        public String getType() {
            return type;
        }
        public void setType(String type) {
            this.type = type;
        }
        public LocalDate getPayementDate() {
            return paymentDate;
        }
        public void setPayementDate(LocalDate payementDate) {
            this.paymentDate = payementDate;
        }
    }

