package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="jpa_doctor_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Doctor {	
   @Id
   @SequenceGenerator(name = "gen1",sequenceName = "docid_seq",initialValue = 100,allocationSize = 1)
   @GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
   private Integer doc_id;
   @NonNull
   private String doc_name;
   @NonNull
   private Double income;
   @NonNull
   @Column(name="specialization")
   private String spec;
   
}
