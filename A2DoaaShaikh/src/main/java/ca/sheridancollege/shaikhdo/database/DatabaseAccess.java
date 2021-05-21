/*
 * Author: Doaa Shaikh, 991588387
 * Assignment 2
 */

package ca.sheridancollege.shaikhdo.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.shaikhdo.beans.MovieReview;

@Repository

public class DatabaseAccess {

	@Autowired
	protected NamedParameterJdbcTemplate jdbc;

	public void insertReview(MovieReview movrev) {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();
		String query = "INSERT INTO moviereview(name, review, sub_date, sub_time) VALUES (:name, :review, :sub_date, :sub_time)";
		namedParameters.addValue("name", movrev.getName());
		namedParameters.addValue("review", movrev.getReview());
		namedParameters.addValue("sub_date", movrev.getSub_date());
		namedParameters.addValue("sub_time", movrev.getSub_time());
		int rowsAffected = jdbc.update(query, namedParameters);
		if (rowsAffected > 0)
			System.out.println("Inserted review into database.");
	}

	public List<MovieReview> getMovieReviewList() {
		MapSqlParameterSource namedParameters = new MapSqlParameterSource();

		String query = "SELECT * from moviereview";

		return jdbc.query(query, namedParameters, new BeanPropertyRowMapper<MovieReview>(MovieReview.class));
	}
}
