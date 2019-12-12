package com.scrotify.matrimony.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="from_user_id")
	private UserDetail fromUserId;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="interest_user_id")
	private UserDetail interestUserId;
	private LocalDate date;

}
