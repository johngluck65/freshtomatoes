package net.gluck.domain.persistence;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import net.gluck.domain.Movie;

/* @author John Gluck
 * @date 03/08/2016
 * @description This is basically a Repository.  Currently it is mostly being used for testing
 */

public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
	List<Movie> findByName(@Param("name") String name);
}
