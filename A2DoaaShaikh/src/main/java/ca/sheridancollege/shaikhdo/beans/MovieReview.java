/*
 * Author: Doaa Shaikh, 991588387
 * Assignment 2
 */

package ca.sheridancollege.shaikhdo.beans;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class MovieReview {

	private String name;
	private int id;
	private String review;
	/*
	 * I used this after seeing the post in the discussion forum, I fixed the
	 * formatting a little and got it to work! Appending the Date/Time with .now()
	 * gives the current date/time from the system's clock
	 */
	@DateTimeFormat(pattern = "uuuu-MM-dd")
	private LocalDate sub_date = LocalDate.now();
	@DateTimeFormat(pattern = "HH:mm")
	private LocalTime sub_time = LocalTime.now();

}
