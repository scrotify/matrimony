package com.scrotify.matrimony.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="interest_profile")
public class ProfileInterest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interestId;
	private Long fromUserId;
	private Long interestUserId;
	private LocalDate date;

}
